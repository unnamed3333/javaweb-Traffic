package ticket.service.impl;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import core.bean.Ticket;
import ticket.dao.TicketDao;
import ticket.dao.impl.TicketDaoImpl;
import ticket.service.TicketService;

@WebServlet("/TicketServiceImpl")
public class TicketServiceImpl implements TicketService {
	private TicketDao dao;

	public TicketServiceImpl() {
		dao = new TicketDaoImpl();
	}

	@Override
	public List<Ticket> findTicketByMemId(Integer memId, Integer status) {
		if (status == 0 || status == 2) {
			return dao.selectByMemId(memId, status);
		} else {
			return null;
		}
	}

	@Override
	public List<Ticket> findTicketByMemIdHistory(Integer memId) {
		return dao.selectByMemIdHistory(memId);
	}
	
}
