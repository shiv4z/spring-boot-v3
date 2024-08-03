package in.shiv.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "User")
public class User {
    @JacksonXmlProperty(localName = "id")
    private String id;
    
    @JacksonXmlProperty(localName = "name")
    private String name;
    
    @JacksonXmlProperty(localName = "visibleAttributes")
    private VisibleAttributes visibleAttributes;
    
    @JacksonXmlProperty(localName = "devices")
    private Devices devices;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VisibleAttributes getVisibleAttributes() {
		return visibleAttributes;
	}

	public void setVisibleAttributes(VisibleAttributes visibleAttributes) {
		this.visibleAttributes = visibleAttributes;
	}

	public Devices getDevices() {
		return devices;
	}

	public void setDevices(Devices devices) {
		this.devices = devices;
	}

	public User(String id, String name, VisibleAttributes visibleAttributes, Devices devices) {
		this.id = id;
		this.name = name;
		this.visibleAttributes = visibleAttributes;
		this.devices = devices;
	}
    
    // Constructors, getters, and setters
}