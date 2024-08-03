package in.shiv;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import in.shiv.entity.Employee;
import in.shiv.repository.EmployeeRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeRepo repo = context.getBean(EmployeeRepo.class);
		//System.out.println(repo.getClass().getName());
		
	//	Employee e1=new Employee(101, "Ram", 5500.0, "IT");
	//	Employee e2=new Employee(102, "Malinga", 16000.0, "ADMIN");
//		Employee e3=new Employee(103, "Cathy", 9000.0, "MANAGER");
//		Employee e4=new Employee(104, "John", 7000.0, "HR");
//		Employee e5=new Employee(105, "Swamy", 15000.0, "SALES");
//		Employee e6=new Employee(106, "Ravindra", 1000.0, "ADMIN");
//		
//		repo.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6));
		
//		Sort sort = Sort.by("dept").descending();
//		List<Employee> empList = repo.findAll(sort);
//		empList.forEach(System.out::println);
		
		Pageable page = PageRequest.of(1, 3);
		Page<Employee> pages = repo.findAll(page);
		List<Employee> empList = pages.getContent();
		empList.forEach(System.out::println);
		
//		if(repo.existsById(e2.getEmpId())) {
//			repo.upateRecord(e2.getEmpId(),e2.getEmpName(),e2.getSalary(),e2.getDept());
//
//		}
		
//		if(repo.existsById(101)) {
//			repo.deleteById(101);
//		}
		
	//	repo.save(107, "ShashiKant", 4000.0, "HR");
		
//		Employee emp = new Employee();
//		emp.setDept("HR");
//		
//		Example<Employee> example = Example.of(emp);
//		List<Employee> empList = repo.findAll(example);
//		empList.forEach(System.out::println);
		
		Employee emp = new Employee();
		emp.setEmpName("Charles");
		emp.setSalary(15000.0);
		emp.setDept("Slaes");
		emp.setEmpId(1);
		emp = repo.save(emp);
		
		System.out.println("Record inserted successfully...");
	}

}
