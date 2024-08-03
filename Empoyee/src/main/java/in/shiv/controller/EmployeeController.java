package in.shiv.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import in.shiv.binding.EmployeeModel;
import in.shiv.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/")
	public String loadPage() {
		return "employee";
	}

	@PostMapping(value = "/register", produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> saveEmployee(@RequestBody EmployeeModel employee,BindingResult br) {
		System.out.println("Employee data: " + employee);
		if(br.hasErrors()) {
			List<String> errorMessages = br.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errorMessages);
		}
		Boolean status = service.save(employee);
		if (status) {
			return new ResponseEntity<>("Data saved successfully.", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Some problem occurred to save the data.",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping(value = "/employees", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<EmployeeModel>> getEmployeeData() {
		List<EmployeeModel> employeeList = service.findAll();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	@GetMapping("/loadData")
	public String loadEmployeeData() {
		return "loadData";
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<String> deleteEmployeeData(@PathVariable("employeeId") Integer employeeId) {
		System.out.println(employeeId);
		Boolean status = service.deleteEmployee(employeeId);
		if(status) {
			return new ResponseEntity<>("deleted successfully." ,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("some problem coourred to delete" ,HttpStatus.INTERNAL_SERVER_ERROR);	
	}
		
	}
}
