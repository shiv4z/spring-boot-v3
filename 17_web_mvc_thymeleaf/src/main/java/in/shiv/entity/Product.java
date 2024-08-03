package in.shiv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@NotBlank(message = "Name should not be empty")
	private String name;
	
	@NotNull(message = "price shoould not be null")
	@Positive(message = "Price should be positive")
	private Double price;
	
	@NotNull(message = "Quantity should not be null")
	@Positive(message = "Quantity should be positive")
	private Integer quantity;

}
