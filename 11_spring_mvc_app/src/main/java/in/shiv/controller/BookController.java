package in.shiv.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.shiv.model.Book;
import in.shiv.repo.BookRepo;

@Controller
public class BookController {

	@Autowired
	private BookRepo repo;

	@GetMapping("/")
	public ModelAndView openDefaultPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	@GetMapping("/book")
	public ModelAndView index(@RequestParam("bookId") Integer bookId) {
		ModelAndView mav = new ModelAndView();
		System.out.println(bookId);
//		Book book = new Book();
//		book.setBookId(101);
//		book.setBookName("Microservices");
//		book.setBookPrice(1000.0);
		Book book = null;
		Optional<Book> byId = repo.findById(bookId);
		if (byId.isPresent()) {
			book = byId.get();
			mav.addObject("book", book);

		}

		mav.setViewName("index");
		return mav;
	}

}
