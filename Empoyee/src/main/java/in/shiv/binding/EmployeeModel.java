package in.shiv.binding;

import in.shiv.entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeModel {
	
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String role;
	private String designation;
	private Double salary;
	
	
	public EmployeeModel(Employee employee) {
		this.employeeId = employee.getEmployeeId();
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
		this.role = employee.getRole();
		this.designation = employee.getDesignation();
		this.salary = employee.getSalary();
	}

}
