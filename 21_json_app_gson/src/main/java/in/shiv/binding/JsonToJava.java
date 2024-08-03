package in.shiv.binding;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class JsonToJava {
	public static void main(String[] args) {
	//	File f = new File("customer.json");
		Gson gson = new Gson();
		try (JsonReader reader = new JsonReader(new FileReader("customer.json"))) {
            Customer customer = gson.fromJson(reader, Customer.class);
            System.out.println(customer);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
		
	}

}
