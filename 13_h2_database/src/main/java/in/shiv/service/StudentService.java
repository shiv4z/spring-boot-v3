package in.shiv.service;

import java.util.List;

import in.shiv.model.Student;

public interface StudentService {
	public Boolean save(Student s);
	public List<String> getCourses();
	public List<String> getTimings();

}
