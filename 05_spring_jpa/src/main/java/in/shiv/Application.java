package in.shiv;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.shiv.entity.Book;
import in.shiv.repo.BookRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		BookRepository repo = context.getBean(BookRepository.class);
		
//		Book book = new Book();
//		book.setBookId(14);
//		book.setBookName("Swing");
//		book.setBookPrice(200.0);
		
//		Book book1 = new Book();
//		book1.setBookId(15);
//		book1.setBookName("Cloud");
//	book1.setBookPrice(400.0);
//		
//		repo.saveAll(Arrays.asList(book,book1));
//		repo.save(book);
		
//		Optional<Book> book = repo.findById(21);
//		if(book.isPresent()) {
//			System.out.println(book.get());
//		}
		
//		Iterable<Book> books = repo.findAllById(Arrays.asList(11,12,13));
//		for(Book book : books) {
//			System.out.println(book);
//		}
		
//		Iterable<Book> books = repo.findAll();
//		for(Book book : books) {
//			System.out.println(book);
//		}
		
//		boolean status = repo.existsById(41);
//		System.out.println("Record status :: "+status);
		
//		long count = repo.count();
//		System.out.println(count);
		
		//repo.delete(book);
		
	//	repo.deleteAll(Arrays.asList(book, book1));
		
//		List<Book> books = repo.findByBookPriceGreaterThanEqual(1000.0);
//		for(Book book : books) {
//			System.out.println(book);
//		}
//		
//		List<Book> books = repo.findByBookNameStartingWith("s");
//		for(Book book : books) {
//			System.out.println(book);
//		}
		
		List<Book> books = repo.getAllBooks(1000.0);
		for(Book book : books) {
			System.out.println(book);
		}
		System.out.println(" =========================================== ");
		List<Book> books2 = repo.getBooks(1000.0);
		for(Book book :books2) {
			System.out.println(book);
		}
				
		System.out.println("Record inserted successfully...");
	}

}
