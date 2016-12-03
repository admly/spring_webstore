package webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;


@Repository
public class InMemoryProductRepository implements ProductRepository{
	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {
		Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym ekranem o rozdzielczości 640X1136 i 8-megapikselowym aparatem");
		iphone.setCategory("Smartfon");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		
		Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorem Intel Core 3. generacji");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);
		
		Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon™ S4 Pro");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);
		
		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
	}
	public List<Product> getAllProducts() {
		return listOfProducts;
	}
	
	public Product getProductById(String productId) {
		Product productById = null;
		for(Product product : listOfProducts) {
			if(product!=null && product.getProductId()!=null && product.getProductId().equals(productId)){
				productById = product;
				break;
				}
		}
		if(productById == null){
			throw new IllegalArgumentException("Brak produktu o wskazanym id: "+ productId);
			}
		return productById;
		}
	
	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<Product>();
		for(Product product: listOfProducts) {
			if(category.equalsIgnoreCase(product.getCategory())){
			productsByCategory.add(product);
			}
		}
		return productsByCategory;
	}
	
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")) {
			for(String brandName: filterParams.get("brand")) {
				for(Product product: listOfProducts) {
					if(brandName.equalsIgnoreCase(product.getManufacturer())){
						productsByBrand.add(product);
					}
				}
			}
		}	
		if(criterias.contains("category")) {
			for(String category: filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
	}

	public List<Product> getProductsByLowPrice(BigDecimal low_price) {
		List <Product> productsByLowPrice = new ArrayList<Product>();
		for(Product product : listOfProducts){
			if(low_price.compareTo(product.getUnitPrice()) < 0){
				productsByLowPrice.add(product);
			}
		}
		return productsByLowPrice;	
	}
	

	public List<Product> getProductsByHighPrice(BigDecimal high_price) {
		List <Product> productsByHighPrice = new ArrayList<Product>();
		for(Product product : listOfProducts){
			if(high_price.compareTo(product.getUnitPrice()) > 0){
				productsByHighPrice.add(product);
			}
		}
		return productsByHighPrice;
	}
	
	

	public Set <Product> getProductsByPriceInterval(Map<String, List<String>> priceIntervalFilter) {
		 Set<Product> productsByPriceHigh = new HashSet<Product>();
		 List<Product> productsByPriceLow = new ArrayList<Product>();
		 Set<String> criterias = priceIntervalFilter.keySet();
		 
		 if(criterias.contains("low")){
			 BigDecimal low = new BigDecimal(priceIntervalFilter.get("low").get(0));
			 			productsByPriceLow = getProductsByLowPrice(low);
					}
		 
		 if(criterias.contains("high")) {
			 BigDecimal high = new BigDecimal(priceIntervalFilter.get("high").get(0));
			 productsByPriceHigh.addAll(this.getProductsByHighPrice(high));
		 }
		
			productsByPriceHigh.retainAll(productsByPriceLow);
			return productsByPriceHigh;
	}
	
	public List <Product> getProductsByManufacturer(String manufacturer){
		List <Product> productsByManufacturer = new ArrayList<Product>();
		for(Product product : listOfProducts){
			if(manufacturer.equals(product.getManufacturer())){
				productsByManufacturer.add(product);
			}
		}
		return productsByManufacturer;	
	}
	
	
	public Set <Product> getProductsByManufacturerAndPrice(String category, String manufacturer, 
			Map<String, List<String>> priceIntervalParams ){
		List<Product> productsByCategory = getProductsByCategory(category);
	    List<Product> productsByManufacturer = getProductsByManufacturer(manufacturer);
	    Set<Product> productsByPrice = new HashSet<Product>();
	    Set<Product> filteredProducts = new HashSet<Product>();
	    
	    productsByPrice.addAll(getProductsByPriceInterval(priceIntervalParams));
	    
	    for(Product categoryProduct: productsByCategory) {
	        for(Product manufacturerProduct: productsByManufacturer) {
	            for(Product priceProduct: productsByPrice) {
	                if(priceProduct.equals(manufacturerProduct) && manufacturerProduct.equals(categoryProduct)) {
	                    filteredProducts.add(priceProduct);
	                }
	            }
	        }
	    }
	    return filteredProducts;
	    
	}
	public void addProduct(Product product) {
		listOfProducts.add(product);
		}
		
	
}