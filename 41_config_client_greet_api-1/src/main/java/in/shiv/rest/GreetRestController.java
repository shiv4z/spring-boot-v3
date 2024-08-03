package in.shiv.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {
	
	
	@Value("${msg}")
	private String msg;
	
	@GetMapping("/greet")
	public String greetMsg() {
		return msg;
	}

}
