package in.shiv.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import in.shiv.binding.Passenger;
import in.shiv.binding.Ticket;
import in.shiv.service.BookingService;

@Service
public class BookingSeviceImpl implements BookingService {

	private static String baseUrl = "http://localhost:8080/";
//	@Override
//	public Ticket bookTicket(Passenger passenger) {
//		RestTemplate restTemplate = new RestTemplate();
//		String url = baseUrl+"/book";
//		ResponseEntity<Ticket> response = restTemplate.postForEntity(url, passenger, Ticket.class);
//		if(response != null) {
//			return response.getBody();
//		}
//		return null;
//	}
//
//	@Override
//	public Ticket getTicket(Integer ticketId) {
//		RestTemplate restTemplate = new RestTemplate();
//		String url = baseUrl + "/ticket/{ticketId}";
//		ResponseEntity<Ticket> response = restTemplate.getForEntity(url, Ticket.class, ticketId);
//        if(response != null) {
//        	return response.getBody();
//         }
//		return null;
//	}

	@Override
	public Ticket bookTicket(Passenger passenger) {
		String url = baseUrl+"/book";
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.post()
				                 .uri(url)
				                 .bodyValue(passenger)
				                 .retrieve()
				                 .bodyToMono(Ticket.class)
				                 .block();
;		return ticket;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		String url = baseUrl + "/ticket/{ticketId}";
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.get()
				                 .uri(url, ticketId)
				                 .retrieve()
				                 .bodyToMono(Ticket.class)
				                 .block();
		return ticket;
	}

}
