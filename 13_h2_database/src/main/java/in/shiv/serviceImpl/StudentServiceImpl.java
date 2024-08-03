package in.shiv.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.shiv.entity.StudentEntity;
import in.shiv.model.Student;
import in.shiv.repository.StudentRepository;
import in.shiv.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;
	@Override
	public Boolean save(Student s) {
		System.out.println(s);
		StudentEntity se = new StudentEntity();
		BeanUtils.copyProperties(s, se);
		System.out.println(se);
		se.setTimings(Arrays.toString(s.getTimings()));
		repo.save(se);
		return true;
	}
	@Override
	public List<String> getCourses() {
		return Arrays.asList("Java", "Python", "SpringBoot", "MicroService");
	}
	@Override
	public List<String> getTimings() {
		return Arrays.asList("Morning","Afternoon","Evening");
	}

}
