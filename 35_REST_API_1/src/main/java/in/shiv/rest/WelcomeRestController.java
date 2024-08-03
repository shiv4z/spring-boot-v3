package in.shiv.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class WelcomeRestController {

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String msg = "Welcome to the micro-services";
		return msg;
	}
	
	@GetMapping("/end")
	public String getEndMsg() {
		String msg = "Thanks For using.";
		return msg;
	}

}
