package in.shiv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shiv.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
