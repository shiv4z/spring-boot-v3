package in.shiv.service;

import in.shiv.binding.Passenger;
import in.shiv.binding.Ticket;

public interface BookingService {
	
	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicket(Integer TicketId);

}
