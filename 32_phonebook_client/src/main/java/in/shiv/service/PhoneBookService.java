package in.shiv.service;

import java.util.List;

import in.shiv.binding.PhoneBook;

public interface PhoneBookService {
	public String save(PhoneBook phoneBook);
	
	public List<PhoneBook> getContacts();

	public PhoneBook getContact(Integer id);
}
