package webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import webstore.domain.Product;


public interface ProductService {
	List <Product> getAllProducts();
	Product getProductById(String productId);	
	List<Product> getProductsByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
