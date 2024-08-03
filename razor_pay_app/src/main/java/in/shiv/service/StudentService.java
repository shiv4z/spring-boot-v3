package in.shiv.service;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import in.shiv.entity.StudentOrder;
import in.shiv.repo.StudentOrderRepo;

@Service
public class StudentService {


	@Autowired
	private StudentOrderRepo repo;

	@Value("${razorpay.key.id}")
	private String razorpayKey;

	@Value("${razorpay.secret.key}")
	private String razorpaySecretKey;

	private RazorpayClient client;
	
	
	public StudentOrder createOrder(StudentOrder stuOrder) throws RazorpayException {
		 JSONObject orderReq = new JSONObject();
		 orderReq.put("amount", stuOrder.getAmount() * 100);
		 orderReq.put("currency", "INR");
		 orderReq.put("receipt", stuOrder.getEmail());
		
		this.client = new RazorpayClient(razorpayKey, razorpaySecretKey);
		
		//to create an order into razor pay
		Order razorpayOrder = client.orders.create(orderReq);
		stuOrder.setRazorpayOrderId(razorpayOrder.get("id"));
		stuOrder.setOrderStatus(razorpayOrder.get("status"));
		
		 repo.save(stuOrder);
		return stuOrder;
	}

	
	public StudentOrder updateOrder(Map<String, String> responsePayLoad) {
		String razorpayOrderId = responsePayLoad.get("razorpay_order_id");
		StudentOrder order = repo.findByRazorpayOrderId(razorpayOrderId);
		order.setOrderStatus("PAYMENT_COMPLETED");
		StudentOrder updatedOrder = repo.save(order);
		return updatedOrder;
		
		}
}
