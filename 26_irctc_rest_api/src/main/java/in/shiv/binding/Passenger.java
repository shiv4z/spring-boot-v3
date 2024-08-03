package in.shiv.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Passenger {

	private String name;
	private String source;
	private String destination;
	private String date;
	private Integer trainNo;
	private Double cost;
	
}
