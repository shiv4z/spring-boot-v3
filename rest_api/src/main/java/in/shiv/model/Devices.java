package in.shiv.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Devices {
    @JacksonXmlProperty(localName = "device")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Device> deviceList;

	public Devices(List<Device> deviceList) {
		this.deviceList = deviceList;
	}

	public List<Device> getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List<Device> deviceList) {
		this.deviceList = deviceList;
	}
    
    // Constructors, getters, and setters
    
}
