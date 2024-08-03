package in.shiv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.shiv.binding.Passenger;
import in.shiv.binding.Ticket;
import in.shiv.service.BookingService;

@Controller
public class WelcomeController {
	
	@Autowired
	private BookingService service;
	
	
	@GetMapping("/")
	public String loadPage(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "bookingPage";
	}

	@PostMapping("/book")
	public String bookTicket(Passenger passenger, Model model) {
		System.out.println(passenger);
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("ticket", ticket.getTicketId());
		model.addAttribute("passenger", new Passenger());
		return "bookingPage";
	}
	
	@GetMapping("/view")
	public String loadViewTicketPage(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "view";
	}
	
	@GetMapping("/ticket")
	public String getTicket(@RequestParam("ticketId") Integer ticketId,Model model) {
		System.out.println(ticketId);
		Ticket ticket = service.getTicket(ticketId);
		model.addAttribute("ticket", ticket);
		return "view";
	}
}
