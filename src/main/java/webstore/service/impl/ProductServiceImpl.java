package webstore.service.impl;

import java.util.List;

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

}
