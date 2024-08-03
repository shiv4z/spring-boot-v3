package in.shiv.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class VisibleAttribute {
    @JacksonXmlProperty(localName = "name")
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VisibleAttribute(String name) {
		this.name = name;
	}
    
    // Constructors, getters, and setters
    
}
