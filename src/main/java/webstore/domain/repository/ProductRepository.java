package webstore.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import webstore.domain.Product;


public interface ProductRepository {
	List <Product> getAllProducts();
	Product getProductById(String productId);	
	List <Product> getProductsByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	List <Product> getProductsByLowPrice(BigDecimal low_price);
	List <Product> getProductsByHighPrice(BigDecimal high_price);
	Set<Product> getProductsByPriceInterval(Map<String, List<String>> priceIntervalFilter);
	List <Product> getProductsByManufacturer(String manufacturer);
	Set <Product> getProductsByManufacturerAndPrice(String category, String manufacturer, 
			Map<String, List<String>> priceIntervalParams );
	
}