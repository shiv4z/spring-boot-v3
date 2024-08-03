package in.shiv.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.shiv.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

	public List<Book> findByBookPriceGreaterThanEqual(Double bookPrice);
	
	public List<Book> findByBookNameStartingWith(String bookName);
	
	@Query("from Book where bookPrice >= :price")
	public List<Book> getAllBooks(Double price);
	
	@Query(value="select * from book where book_price >= :price", nativeQuery = true)
	public List<Book> getBooks(Double price);
	
}
