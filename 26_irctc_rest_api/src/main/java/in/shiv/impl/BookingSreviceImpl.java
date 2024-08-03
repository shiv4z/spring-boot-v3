package in.shiv.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import in.shiv.binding.Passenger;
import in.shiv.binding.Ticket;
import in.shiv.service.BookingService;

@Service
public class BookingSreviceImpl implements BookingService {

	Map<Integer, Ticket> ticketMap = new HashMap<>();
	private Integer ticketId = 1;
	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket ticket = new Ticket();
		//BeanUtils.copyProperties(passenger, ticket);
		ticket.setPassenger(passenger);
		ticket.setTicketId(ticketId);
		ticket.setStatus("CONFIRMED");
		ticketMap.put(ticketId, ticket);
		ticketId++;
		return ticket;
	}

	@Override
	public Ticket getTicket(Integer TicketId) {
		if(ticketMap.containsKey(TicketId)) {
			return ticketMap.get(TicketId);
		}
		return null;
	}

}
