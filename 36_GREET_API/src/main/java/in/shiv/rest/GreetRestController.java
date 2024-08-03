package in.shiv.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.client.FeignClientInterface;

@RestController
public class GreetRestController {
	 
	@Autowired
	private FeignClientInterface client;
	
	@GetMapping("/greet")
	public String greet() {
		String response = client.invoke();
		String msg =  response+", Good Evening";
		return msg;
	}

}
