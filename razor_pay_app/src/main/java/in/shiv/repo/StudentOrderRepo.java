package in.shiv.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shiv.entity.StudentOrder;

public interface StudentOrderRepo extends JpaRepository<StudentOrder, Integer>{
	
	public StudentOrder findByRazorpayOrderId(String razorpayOrderId);

}
