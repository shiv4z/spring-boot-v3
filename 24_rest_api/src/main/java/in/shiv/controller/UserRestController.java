package in.shiv.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.User;

@RestController
public class UserRestController {
	
	Map<Integer, User> map = new HashMap<>();
	
	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		System.out.println(user);
		map.put(user.getUserId(), user);
		return new ResponseEntity<>("User save successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public User getUser(@RequestParam("userid")Integer userId) {
		System.out.println(userId);
		User user = map.get(userId);
		return user;
	}

	@GetMapping("/user/{id}/data")
	public User getUserData(@PathVariable("id")Integer userId) {
		System.out.println(userId);
		User user = map.get(userId);
		return user;
	}
	
}
