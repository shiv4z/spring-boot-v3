package in.shiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import in.shiv.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	@Transactional
	@Modifying
	@Query("update Employee set empName =:empName,salary=:salary,dept=:dept where empId=:empId")
	public int upateRecord(@Param("empId") Integer empId, 
            @Param("empName") String empName, 
            @Param("salary") Double salary, 
            @Param("dept") String dept);
	
	@Query("delete from Employee where empId=:empId")
	public int deleteRecord(Integer empId);
	
	@Transactional
	@Modifying
	@Query("insert into Employee(empId, empName, salary, dept) values (:empId,:empName,:salary,:dept)")
	public void save(@Param("empId")Integer empId,
			@Param("empName")String empName,
			@Param("salary")Double salary,
			@Param("dept")String dept);
}
