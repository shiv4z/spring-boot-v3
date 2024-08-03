package in.shiv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.shiv.entity.Product;
import in.shiv.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository repo; 
	
	@GetMapping("/")
	public String loadPage(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}
	
	@PostMapping("/save")
	public String save(Product p,Model model) {
		System.out.println(p);
		Product product = repo.save(p);
		if(product.getPid() != null) {
			model.addAttribute("msg", "Product has been saved");
			model.addAttribute("product", new Product());
		}
		return "index";
	}

	@GetMapping("/view")
	public String viewProducts(Model model) {
		model.addAttribute("products", repo.findAll());
		return "view";
	}
}
