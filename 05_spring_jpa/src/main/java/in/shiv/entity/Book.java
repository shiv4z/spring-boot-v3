package in.shiv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
	
	@Id
	private Integer bookId;
	private String bookName;
	private Double bookPrice;

}
