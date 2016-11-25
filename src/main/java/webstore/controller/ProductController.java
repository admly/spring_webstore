package webstore.controller;
import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import webstore.domain.Product;

@Controller
public class ProductController {
	@RequestMapping("/products")
	public String list(Model model) {
		Product iphone = new Product("P1234", "IPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym wyświetlaczem o rozdzielczości 640X1136 oraz 8-megapikselowym aparatem");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		model.addAttribute("product", iphone);
		return "products";
	}
}
