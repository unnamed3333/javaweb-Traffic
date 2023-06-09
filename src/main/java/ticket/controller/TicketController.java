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

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String pathInfo = request.getPathInfo();
//		pathInfo = pathInfo.substring(1);
//		String[] pathVariables = pathInfo.split("/");
//
//		if (pathVariables.length == 1) {
//			Integer id = Integer.parseInt(pathVariables[0]);
//			List<Ticket> list = SERVICE.findTicketByMemIdHistory(Integer.valueOf(id));
//			list.forEach(Ticket -> {
//				for (int i = 0; i < Ticket.getAppendix().size(); i++) {
//					String appendixBase64 = Base64.getEncoder().encodeToString(Ticket.getAppendix().get(i));
//					Appendix appendix = new Appendix();
//					appendix.setAppendixBase64(appendixBase64);
//					appendix.setAppendix(null);
//				}
//
//			});
//			response.getWriter().write(GSON.toJson(list));
//
//		} else {
//			Integer id = Integer.parseInt(pathVariables[0]);
//			Integer status = Integer.parseInt(pathVariables[1]);
//			List<Ticket> list = SERVICE.findTicketByMemId(Integer.valueOf(id), Integer.valueOf(status)); // 把從前端取得的member傳進service
//
//			list.forEach(Ticket -> {
//				for (int i = 0; i < Ticket.getAppendix().size(); i++) {
//					String appendixBase64 = Base64.getEncoder().encodeToString(Ticket.getAppendix().get(i));
//					Appendix appendix = new Appendix();
//					appendix.setAppendixBase64(appendixBase64);
//					appendix.setAppendix(null);
//				}
//
//			});
//			response.getWriter().write(GSON.toJson(list));
//		}
//
//	}

}
