package in.shiv.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.shiv.entity.Product;
import in.shiv.repsitory.ProductRepository;

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
	public String save(@Validated @ModelAttribute("product")Product product,BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "index";
		}
		Product p = repo.save(product);
		if(p.getPid() != null) {
			model.addAttribute("msg", "Product saved.");
			model.addAttribute("product", new Product());
		}
		return "index";
	}
	
	@GetMapping("/view")
	public String view(Model model) {
		model.addAttribute("products", repo.findAll());
		return "view";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("pid")Integer pid,Model model) {
	    repo.deleteById(pid);
	    model.addAttribute("msg", "Product deleted.");
	    model.addAttribute("products", repo.findAll());
		return "view";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("pid")Integer pid,Model model) {
		Optional<Product> findById = repo.findById(pid);
		if(findById.isPresent()) {
			model.addAttribute("product", findById.get());
		}
		return "index";
	}
}


















