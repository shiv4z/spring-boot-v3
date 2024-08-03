package in.shiv.binding;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Customer {
	@JsonProperty(value ="customer")
	@NotNull(message = "customer id should not be null")
	private Integer cid;
	
	@NotBlank(message ="Name should not be blank")
	private String name;
	
	@NotNull(message ="Phone no should not be null")
	@Min(value=10, message="min length should be 10")
	@Max(value=11, message="max length should be 10")
	private Long phoneNo;
	
	@NotNull(message="address should not be null")
	private Address address;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", phoneNo=" + phoneNo + ", address=" + address + "]";
	}

	
}
