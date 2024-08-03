package in.shiv.binding;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJava {
	public static void main(String[] args) throws IOException{
		File f = new File("json");
		ObjectMapper mapper = new ObjectMapper();
		Customer customer = mapper.readValue(f, Customer.class);
		
		System.out.println(customer);
		
		System.out.println("Json file reading successfully.");
	}

}
