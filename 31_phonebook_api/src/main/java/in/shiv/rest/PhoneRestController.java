package in.shiv.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.shiv.binding.PhoneBook;
import in.shiv.service.PhoneBookService;

@RestController
public class PhoneRestController {

	@Autowired
	private PhoneBookService service;

	@GetMapping("/contacts")
	public ResponseEntity<?> getAllContacts() {
		List<PhoneBook> contacts = service.getContacts();
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody @Validated PhoneBook phoneBook, BindingResult br) {
		System.out.println(phoneBook);
		String msg = null;
		Boolean status = Boolean.FALSE;
		Map<String, String> errors = new HashMap<>();
		if (br.hasErrors()) {
			for (FieldError error : br.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		status = service.save(phoneBook);
		if (status) {
			msg = "Contact saved successfully";
		} else {
			msg = "Something went wrong";
		}

		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/contact/{id}")
	public ResponseEntity<PhoneBook> getContactById(@PathVariable("id") Integer id) {
		System.out.println(id);
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		PhoneBook phoneBook = service.getContactById(id);
		return new ResponseEntity<>(phoneBook, HttpStatus.OK);
	}
}
