package in.shiv.model;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class VisibleAttributes {
    @JacksonXmlProperty(localName = "visibleAttribute")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<VisibleAttribute> visibleAttributeList;

	public List<VisibleAttribute> getVisibleAttributeList() {
		return visibleAttributeList;
	}

	public void setVisibleAttributeList(List<VisibleAttribute> visibleAttributeList) {
		this.visibleAttributeList = visibleAttributeList;
	}

	public VisibleAttributes(List<VisibleAttribute> visibleAttributeList) {
		this.visibleAttributeList = visibleAttributeList;
	}
    
    // Constructors, getters, and setters
    
}