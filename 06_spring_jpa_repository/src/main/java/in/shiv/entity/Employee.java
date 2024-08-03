package in.shiv.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer empId;
	private String empName;
	private Double salary;
	private String dept;
	
	@CreationTimestamp
	@Column(name="created_on", updatable = false )
	private LocalDate createdOn;
	
	@UpdateTimestamp
	@Column(name="updated_on", insertable = false)
	private LocalDate updatedOn;
	
	

}
