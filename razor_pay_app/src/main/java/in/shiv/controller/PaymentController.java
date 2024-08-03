package in.shiv.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.razorpay.RazorpayException;

import in.shiv.entity.StudentOrder;
import in.shiv.service.StudentService;

@Controller
public class PaymentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String loadPage() {
		return "index";
	}
	
	@PostMapping(value="/create-order", produces ="application/json")
	@ResponseBody
	public ResponseEntity<StudentOrder> createOrder(@RequestBody StudentOrder studentOrder) throws RazorpayException{
		studentOrder = service.createOrder(studentOrder);
		return new ResponseEntity<>(studentOrder , HttpStatus.CREATED);
	}
	
	@PostMapping("/handle-payment-callback")
	public String hanldePaymentCallBack(@RequestParam Map<String, String> responsePayLoad) {
		System.out.println(responsePayLoad);
		StudentOrder updateOrder = service.updateOrder(responsePayLoad);
		return "success";
	}

}
