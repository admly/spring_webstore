package webstore.domain.repository;

import java.util.List;
import webstore.domain.Product;


public interface ProductRepository {
	List <Product> getAllProducts();
	Product getProductById(String productId);	
}
