package in.shiv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shiv.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}