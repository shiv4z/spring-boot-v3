package in.shiv.model;

import lombok.Data;

@Data
public class Student {
	
	private String name;
	private String email;
	private Character gender;
	private String course;
	private String[] timings;

}
