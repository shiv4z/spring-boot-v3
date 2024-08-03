package in.shiv.binding;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class JavaToXml {
	public static void main(String[] args) throws JAXBException {
		Address address = new Address();
		address.setCity("Varanasi");
		address.setState("Uttar Pradesh");
		address.setCountry("India");
		
		Customer customer = new Customer();
		customer.setCid(102);
		customer.setName("Shiv Prasad");
		customer.setPhoneNo(9506108463l);
		customer.setAddress(address);
		
		JAXBContext context = JAXBContext.newInstance(Customer.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(customer, new File("customer.xml"));
		System.out.println("Xml has been created...");
	}

}
