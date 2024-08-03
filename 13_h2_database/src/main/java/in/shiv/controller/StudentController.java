package in.shiv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import in.shiv.model.Student;
import in.shiv.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public ModelAndView loadIndexPage() {
		ModelAndView mav = init();
		return mav;
	}

	private ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("student", new Student());
		mav.addObject("courses", service.getCourses());
		mav.addObject("timings", service.getTimings());
		mav.setViewName("index");
		return mav;
	}

	@PostMapping("/save")
	public ModelAndView save(Student s) {
		ModelAndView mav = init();
		System.out.println(s);
		Boolean status = service.save(s);
		if(status) {
			mav.addObject("msg", "Data has been Saved.");
		}

		return mav;
	}
}
