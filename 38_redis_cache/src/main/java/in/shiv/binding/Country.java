package in.shiv.binding;

import java.io.Serializable;

import lombok.Data;

@Data
public class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer countryCode;

}
