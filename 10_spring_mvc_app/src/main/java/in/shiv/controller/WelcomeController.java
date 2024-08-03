package in.shiv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@GetMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Welcome to Spring Boot...");
		mav.setViewName("message");
		return mav;
		
	}
	
	@GetMapping("/greet")
	public ModelAndView greet() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Hi! Good Morning..");
		mav.setViewName("message");
		return mav;
		
	}

}
