package in.shiv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.Passenger;
import in.shiv.binding.Ticket;
import in.shiv.service.BookingService;

@RestController
public class BookingRestController {
	
	@Autowired
	private BookingService service;

	@PostMapping(value="/book",
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){
		System.out.println(passenger);
		Ticket ticket = service.bookTicket(passenger);
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/ticket/{ticketId}",
			produces = "application/json")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		System.out.println(ticketId);
		return service.getTicket(ticketId);
	}
}

