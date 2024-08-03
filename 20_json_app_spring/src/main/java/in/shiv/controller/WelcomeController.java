package in.shiv.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.Address;
import in.shiv.binding.Customer;

@RestController
public class WelcomeController {
	
	@GetMapping("/customer")
	public Customer getCustomer() {
		Customer c = new Customer();
		c.setCid(101);
		c.setName("Mackale");
		c.setPhoneNo(9506108463l);
		
		Address a = new Address();
		a.setCity("New Delhi");
		a.setState("New Delhi");
		a.setCountry("India");
		
		c.setAddress(a);
		return c;
	}

	@GetMapping("/")
	public ResponseEntity<Customer> customer() {
		Customer c = new Customer();
		c.setCid(101);
		c.setName("Mackale");
		c.setPhoneNo(9506108463l);
		
		Address a = new Address();
		a.setCity("New Delhi");
		a.setState("New Delhi");
		a.setCountry("India");
		
		c.setAddress(a);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	 
	@PostMapping("/save")
	public ResponseEntity<?> saveCustomer(@Validated @RequestBody Customer customer,BindingResult br){
		if(br.hasErrors()) {
			Map<String , String> errors = new HashMap<>();
			for(FieldError e :br.getFieldErrors()) {
				System.out.println(e.getRejectedValue());
				errors.put(e.getField(), e.getDefaultMessage());
			}
			return new ResponseEntity<>(errors , HttpStatus.BAD_REQUEST);
			//return new ResponseEntity<>(customer ,HttpStatus.BAD_REQUEST);
		}
		System.out.println(customer.toString());
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}
}
