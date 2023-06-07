package ticket.service;

import java.util.List;

import core.bean.Ticket;

public interface TicketService {
	
	List<Ticket> findTicketByMemId(Integer memId, Integer status);

	List<Ticket> findTicketByMemIdHistory(Integer memId);

}
