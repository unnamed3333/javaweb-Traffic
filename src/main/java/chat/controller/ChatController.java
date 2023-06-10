package chat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import chat.service.ChatService;
import chat.service.impl.ChatServiceImpl;
import core.bean.Chat;
import core.bean.Member;

@WebServlet("/Chat/ChatController/*")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	讓兩邊時間格式一樣
	private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final ChatService SERVICE = new ChatServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo(); // 取得網址後面帶的值 EX:member/1/2/3 拿到/1/2/3 但是拿到要拆開
		try {
			pathInfo = pathInfo.substring(1); // 去掉/1/2/3 開頭的斜線 要不然拆要會多個空白
			String[] pathVariables = pathInfo.split("/"); // 把1/2/3拆成陣列 0=第一個
			Integer chatroomid = Integer.parseInt(pathVariables[0]);
			Integer memid = Integer.parseInt(pathVariables[1]);
			Integer readstatus = SERVICE.updateStatus(Integer.valueOf(chatroomid), Integer.valueOf(memid));
			List<Chat> list = SERVICE.selectChat(Integer.valueOf(chatroomid), Integer.valueOf(memid)); // 把從前端取得的member傳進service
			resp.getWriter().write(GSON.toJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("輸入文字");
		Chat chat = GSON.fromJson(req.getReader(), Chat.class); //接收前端資料
		boolean result = SERVICE.insertChat(chat); //把值傳給service
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result); //把service傳回來的值放進successful
		resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
	}
}
