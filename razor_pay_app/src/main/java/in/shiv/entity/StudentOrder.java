package in.shiv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "student_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private String name;
	private String email;
	private String phoneNo;
	private String course;
	private Double amount;
	private String orderStatus;
	private String razorpayOrderId;
	
	

}
