package in.shiv.binding;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

import com.google.gson.Gson;

public class JavaToJson {
	public static void main(String[] args) throws IOException {
		Address address = new Address();
		address.setCity("Varanasi");
		address.setState("Uttar Pradesh");
		address.setCountry("India");
		
		Customer customer = new Customer();
		customer.setCid(101);
		customer.setName("Shiv Prasad");
		customer.setPhoneNo(9506108463l);
		customer.setAddress(address);
		
		Gson gson = new Gson();
		//String json = gson.toJson(customer);
		
		 try (FileWriter writer = new FileWriter(new File("customer.json"))) {
	            gson.toJson(customer, writer);
	        } catch (IOException e) {
	            e.printStackTrace();
	            // Handle the exception
	        }
		System.out.println("json file created successfully...");
	}

}
