package in.shiv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.Address;
import in.shiv.binding.Customer;

@RestController
public class DataController {

	@GetMapping(value = "/customer", produces = "application/xml")
	public Customer getCustomer() {
		Address address = new Address();
		address.setCity("Varanasi");
		address.setState("Uttar Pradesh");
		address.setCountry("India");

		Customer customer = new Customer();
		customer.setCid(102);
		customer.setName("Shiv Prasad");
		customer.setPhoneNo(9506108463l);
		customer.setAddress(address);
		return customer;
	}

	@GetMapping(value="/", produces ="application/xml")
	public ResponseEntity<Customer> getData() {
		Address address = new Address();
		address.setCity("Varanasi");
		address.setState("Uttar Pradesh");
		address.setCountry("India");

		Customer customer = new Customer();
		customer.setCid(102);
		customer.setName("Shiv Prasad");
		customer.setPhoneNo(9506108463l);
		customer.setAddress(address);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping(value="/save" , consumes="application/xml")
	public ResponseEntity<?> saveData(@RequestBody Customer customer){
		System.out.println(customer);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}
}
