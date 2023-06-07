package ticket.dao;

import java.util.List;

import core.bean.Ticket;

public interface TicketDao {

	List<Ticket> selectByMemId(Integer memId, Integer status);

	List<Ticket> selectByMemIdHistory(Integer memId);

	List<String> slectAllAppendix(String ticketNo);
}
