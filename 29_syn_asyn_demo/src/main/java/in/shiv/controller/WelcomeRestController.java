package in.shiv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String msg = "Welcome to Rest Api";
		return msg;
	}

}
