package in.shiv.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shiv.binding.PhoneBook;
import in.shiv.entity.Phone;
import in.shiv.repository.PhoneBookRepository;
import in.shiv.service.PhoneBookService;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

	@Autowired
	private PhoneBookRepository repo;

	@Override
	public Boolean save(PhoneBook phoneBook) {
		Boolean flag = Boolean.FALSE;
		try {
			Phone phone = new Phone();
			BeanUtils.copyProperties(phoneBook, phone);
			repo.save(phone);
			flag = Boolean.TRUE;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<PhoneBook> getContacts() {
		List<Phone> contactList = repo.findAll();
		List<PhoneBook> phoneBookList = contactList.stream()
                .map(PhoneBook::new) 
                .collect(Collectors.toList());
		return phoneBookList;
	}

	@Override
	public PhoneBook getContactById(Integer id) {
		PhoneBook phoneBook = new PhoneBook();
		Optional<Phone> byId = repo.findById(id);
		if(byId.isPresent()) {
			 Phone phone = byId.get();
			 BeanUtils.copyProperties(phone, phoneBook);
			 return phoneBook;
		}
		return null;
	}

}
