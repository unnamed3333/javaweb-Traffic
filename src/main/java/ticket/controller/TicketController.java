package ticket.controller;

import javax.servlet.annotation.WebServlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ticket.service.TicketService;
import ticket.service.impl.TicketServiceImpl;

@WebServlet("/Ticket/*")
public class TicketController {
	private static final long serialVersionUID = 1L;
//	讓兩邊時間格式一樣
	private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final TicketService SERVICE = new TicketServiceImpl();

}
