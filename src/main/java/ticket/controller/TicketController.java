package ticket.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import core.bean.Appendix;
import core.bean.Ticket;
import ticket.service.TicketService;
import ticket.service.impl.TicketServiceImpl;

@WebServlet("/Ticket/*")
public class TicketController {
	private static final long serialVersionUID = 1L;
//	讓兩邊時間格式一樣
	private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final TicketService SERVICE = new TicketServiceImpl();

}
