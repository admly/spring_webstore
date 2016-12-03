package webstore.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstore.domain.Product;
import webstore.domain.repository.ProductRepository;
import webstore.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
	public Product getProductById(String productId){
		return productRepository.getProductById(productId);
	}
	
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
		}
	
	public List <Product> getProductsByLowPrice(BigDecimal low_price) {
		return productRepository.getProductsByLowPrice(low_price);
	
	}
	
	public List<Product> getProductsByHighPrice(BigDecimal high_price) {
		return productRepository.getProductsByHighPrice(high_price);

	}
	
	public Set<Product> getProductsByPriceInterval(Map<String, List<String>> priceIntervalFilter) {
		return productRepository.getProductsByPriceInterval(priceIntervalFilter);
	}
	
	public List<Product> getProductsByManufacturer(String manufacturer) {

		return productRepository.getProductsByManufacturer(manufacturer);
	}
	public Set <Product> getProductsByManufacturerAndPrice(String category, String manufacturer, 
			Map<String, List<String>> priceIntervalParams ){
		return productRepository.getProductsByManufacturerAndPrice(category, manufacturer, priceIntervalParams);
	}
	public void addProduct(Product product) {
		productRepository.addProduct(product);
		}
			
}
