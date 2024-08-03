package in.shiv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.shiv.binding.PhoneBook;
import in.shiv.service.PhoneBookService;

@Controller
public class PhoneBookController {
	
	@Autowired
	private PhoneBookService service;
	
	@GetMapping("/")
	public String loadPage(Model model) {
		model.addAttribute("phoneBook", new PhoneBook());
		return "phoneBook";
	}
	
	@PostMapping("/save")
	public String save(PhoneBook phoneBook, Model model) {
		System.out.println(phoneBook);
		String msg = service.save(phoneBook);
			model.addAttribute("msg", msg);
			model.addAttribute("phoneBook", new PhoneBook());
		return "phoneBook";
	}

	@GetMapping("/view")
	public String getAllContacts(Model model) {
		model.addAttribute("phoneBooks", service.getContacts());
		return "view";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id")Integer id,Model model) {
		System.out.println(id);
		PhoneBook contact = service.getContact(id);
		model.addAttribute("phoneBook", contact);
		return "phoneBook";
		
	}
}
