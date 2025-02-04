package in.shiv.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishController {
	
	Logger logger = LoggerFactory.getLogger(WishController.class);
	
	@GetMapping("/wish")
	public String wish(Model model) {
		model.addAttribute("msg", "Good Morning!...");
		Integer x =10/0;
		return "index";
	}

	//local exception handling
//	@ExceptionHandler(ArithmeticException.class)
//	public String handleException(ArithmeticException ae) {
//		logger.info(ae.getMessage());
//		return "errorPage";
//	}
}
