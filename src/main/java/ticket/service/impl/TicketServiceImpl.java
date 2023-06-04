package ticket.service.impl;

import javax.servlet.annotation.WebServlet;

import ticket.dao.TicketDao;
import ticket.service.TicketService;


@WebServlet("/TicketServiceImpl")
public class TicketServiceImpl implements TicketService {
	private TicketDao dao;
	
	
}
