package in.shiv.binding;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Customer {
	
	private Integer cid;
	private String name;
	private Long phoneNo;
	
	private Address address;
	
	

}
