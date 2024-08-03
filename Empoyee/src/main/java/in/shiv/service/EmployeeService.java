package in.shiv.service;

import java.util.List;

import in.shiv.binding.EmployeeModel;

public interface EmployeeService {
	
	public Boolean save(EmployeeModel employee);
	
	public List<EmployeeModel> findAll();

	public Boolean deleteEmployee(Integer employeeId);
}