package in.shiv.binding;

import lombok.Data;

@Data
public class Customer {
	
	private Integer cid;
	private String name;
	private Long phoneNo;
	private Address address;

}
