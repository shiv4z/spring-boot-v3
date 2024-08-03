package in.shiv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.Book;
import in.shiv.binding.Order;

@RestController
public class BookRestController {

	@GetMapping(value = "/book", 
			produces = {"application/json", "application/xml" }
	)
	public Book getBooks() {
		
		Book book = new Book();
		book.setId(101);
		book.setName("SpringBoot");
		book.setPrice(400.0);
		return book;
	}
	
	@PostMapping(value = "/book", 
			consumes = {"application/xml", "application/json"}
			)
	public ResponseEntity<String> saveBook(@RequestBody Book book){
		System.out.println(book);
		return new ResponseEntity<>("Book saved successfully", HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/purchase",
			consumes = {"application/json", "application/xml"},
			produces = {"application/json", "application/xml"}
			)
	public ResponseEntity<Order> pruchase(@RequestBody Book book){
		System.out.println(book);
		Order order = new Order();
		order.setBookId(book.getId());
		order.setOrderId(100);
		order.setPrice(book.getPrice());
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	

}
