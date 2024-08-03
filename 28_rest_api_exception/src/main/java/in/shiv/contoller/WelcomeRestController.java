package in.shiv.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.UserNotFoundException;

@RestController
public class WelcomeRestController {
	
	@GetMapping("/")
	public String loadIndexMsg() {
		return "Index Page loading";
	}
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String msg = "Welcome to springboot and microservices.";
		int result = 10 / 0;
		return msg;
	}

	@GetMapping("/user/{userId}")
	public String getUser(@PathVariable ("userId")Integer userId) throws Exception {
		if(userId == 100) {
			return "Sunny";
		}else if(userId == 200) {
			return "Smith";
		}else {
			throw new UserNotFoundException("User not exist");
		}
	}
	
	
}
