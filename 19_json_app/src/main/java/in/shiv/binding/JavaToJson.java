package in.shiv.binding;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJson {
	public static void main(String[] args)throws IOException {
		
		Address a = new Address();
		a.setCity("New Delhi");
		a.setState("New Delhi");
		a.setCountry("India");
		
		
		Customer c = new Customer();
		c.setCid(101);
		c.setName("Charles");
		c.setPhoneNo(9506108463l);
		c.setAddress(a);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("customer.json"), c);
		
		System.out.println("Json has been ganarated successfully..");
	}

}
