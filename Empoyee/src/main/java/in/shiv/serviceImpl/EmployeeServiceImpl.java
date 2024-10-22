package in.shiv.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shiv.binding.EmployeeModel;
import in.shiv.entity.Employee;
import in.shiv.repo.EmployeeRepo;
import in.shiv.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public Boolean save(EmployeeModel employee) {
		Boolean flag = Boolean.FALSE;
		try {
			Employee emp = new Employee();
			BeanUtils.copyProperties(employee, emp);
			repo.save(emp);
			flag = Boolean.TRUE;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<EmployeeModel> findAll() {
		List<Employee> employeeList = repo.findAll();
		 List<EmployeeModel> employeeModelList = employeeList.stream()
		            .map(EmployeeModel::new) 
		            .collect(Collectors.toList());
		return employeeModelList;
	}

	@Override
	public Boolean deleteEmployee(Integer employeeId) {
		Boolean flag = Boolean.FALSE;
		try {
			repo.deleteById(employeeId);
			flag = Boolean.TRUE;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
