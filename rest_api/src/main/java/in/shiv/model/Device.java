package in.shiv.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Device {
    @JacksonXmlProperty(localName = "name")
    private String name;
    
    @JacksonXmlProperty(localName = "Email_Address")
    private String emailAddress;
    
    @JacksonXmlProperty(localName = "Phone_Number")
    private String phoneNumber;
    
    @JacksonXmlProperty(localName = "serial_Number")
    private String serialNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Device(String name, String emailAddress, String phoneNumber, String serialNumber) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.serialNumber = serialNumber;
	}
    
    // Constructors, getters, and setters
}
