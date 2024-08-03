package in.shiv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetController {
	
	Logger logger = LoggerFactory.getLogger(GreetController.class);
	
	@GetMapping("/greet")
	public String loadIndex(Model model) {
		model.addAttribute("msg", "Welcome to the Springboot");
		System.out.println(10/0);
		return "index";
	}

	@GetMapping("/msg")
	public String welcomeMessage(Model model) {
		model.addAttribute("msg", "welcome to Delhi");
		String s = null;
		System.out.println(s.length());;
		return "index";
	}
	
	//Local Exception handling
	
//	@ExceptionHandler(ArithmeticException.class)
//	public String handleException(ArithmeticException ae) {
//		logger.info(ae.getMessage());
//		return "errorPage";
//	}
//	
//	
//	@ExceptionHandler(NullPointerException.class)
//	public String handleNPE(NullPointerException ne) {
//		logger.error(ne.getMessage());
//		return "errorPage";
//	}
}
