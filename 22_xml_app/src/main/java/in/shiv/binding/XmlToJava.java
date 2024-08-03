package in.shiv.binding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class XmlToJava {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Customer customer = (Customer)unmarshaller.unmarshal(new FileReader(new File("customer.xml")));
		System.out.println(customer);
		System.out.println("unmashalling successful");
	}

}
