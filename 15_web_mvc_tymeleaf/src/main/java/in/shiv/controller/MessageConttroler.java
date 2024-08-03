package in.shiv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageConttroler {
	
	@GetMapping("/welcome")
	public String loadPage(Model model) {
		model.addAttribute("msg", "Welcome to springboot.");
		return "index";
	}

	@GetMapping("/greet")
	public String loadGreetPage(Model model) {
		model.addAttribute("msg", "Good-after noon");
		return "index";
	}
	
	@GetMapping("/load")
	public String loadWelcomePage(Model model) {
		model.addAttribute("msg", "Jsp Page");
		return "welcome";
	}
}
