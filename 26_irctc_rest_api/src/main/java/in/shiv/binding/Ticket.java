package in.shiv.binding;

import lombok.Data;

@Data
public class Ticket {
	
	private Integer ticketId;
	private String status;
	private Passenger passenger;

}
