package in.shiv.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.shiv.binding.PhoneBook;
import in.shiv.service.PhoneBookService;
import reactor.core.publisher.Mono;

@Service
public class PhoneBookServiceImpl implements PhoneBookService{

	private static final String  baseUrl ="http://localhost:8080"; 
	@Override
	public String save(PhoneBook phoneBook) {
		String url = baseUrl +"/save";
		WebClient webClient = WebClient.create();
		   String msg = webClient.post()
				                   .uri(url)
				                   .bodyValue(phoneBook)
				                   .retrieve()
				                   .bodyToMono(String.class)
				                   .block();
		return msg;
	}
	
	@Override
	public List<PhoneBook> getContacts() {
		String url = baseUrl +"/contacts";
		WebClient webClient = WebClient.create();
	      Mono<List<PhoneBook>> contactListMono = webClient.get()
	                .uri(url)
	                .retrieve()
	                .bodyToMono(new ParameterizedTypeReference<List<PhoneBook>>() {});

	        List<PhoneBook> contactList = contactListMono.block(); 
	        return contactList;
	}

	@Override
	public PhoneBook getContact(Integer id) {
		String url = baseUrl +"/contact/{id}";
		WebClient webClient = WebClient.create();
		PhoneBook phone = webClient.get().uri(url, id).retrieve().bodyToMono(PhoneBook.class).block();
		return phone;
	}

}
