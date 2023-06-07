package ticket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import core.bean.Ticket;
import ticket.service.TicketService;
import ticket.service.impl.TicketServiceImpl;

@WebServlet("/FindTicketByMemId/*")
public class FindTicketByMemIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	讓兩邊時間格式一樣
	private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final TicketService SERVICE = new TicketServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo(); // 取得網址後面帶的值 EX:member/1/2/3 拿到/1/2/3 但是拿到要拆開
		try {
			pathInfo = pathInfo.substring(1); // 去掉/1/2/3 開頭的斜線 要不然拆要會多個空白
			String[] pathVariables = pathInfo.split("/"); // 把1/2/3拆成陣列 0=第一個
			Integer id = Integer.parseInt(pathVariables[0]);
			Integer status = Integer.parseInt(pathVariables[1]);
			List<Ticket> list = SERVICE.findTicketByMemId(Integer.valueOf(id), Integer.valueOf(status)); // 把從前端取得的member傳進service
			resp.getWriter().write(GSON.toJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
