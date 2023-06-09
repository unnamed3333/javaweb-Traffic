package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import core.bean.Member;
import member.service.MemberService;
import member.service.impl.MemberServiceImpl;

@WebServlet("/Login/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson GSON = new GsonBuilder()
			.setDateFormat("yyyy/MM/dd HH:mm:ss")
			.create();
	private static final MemberService SERVICE = new MemberServiceImpl();
	
	//註冊
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入POST");
		Member member = GSON.fromJson(req.getReader(), Member.class); //接收前端資料
		System.out.println("hh");
		boolean result = SERVICE.register(member); //把值傳給service
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result); //把service傳回來的值放進successful
		resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
	}
	
	//登入 回傳member 裡面只有ID
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入GET");
		String pathInfo = req.getPathInfo();  //取得網址後面帶的值 EX:member/1/2/3 拿到/1/2/3 但是拿到要拆開
		pathInfo = pathInfo.substring(1); //去掉/1/2/3 開頭的斜線 要不然拆要會多個空白
		String[] pathVariables = pathInfo.split("/"); //把1/2/3拆成陣列 0=第一個
		Member member = new Member();
		member.setPhoneNo(pathVariables[0]);
		member.setPassword(pathVariables[1]);
		member = SERVICE.login(member); //把從前端取得的member傳進service
		
		//紀錄登入狀態
		if (member != null) {
            if (req.getSession(false) != null) {req.changeSessionId();}
            req.getSession().setAttribute("member", member);
        }
		
		resp.getWriter().write(GSON.toJson(member));
	}
	
	//編輯個人資料
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入PUT");
		Member member = GSON.fromJson(req.getReader(), Member.class); //接收前端資料
		System.out.println(member);
		//這3行取得登入的人的ID
		HttpSession session = req.getSession();
		Member seMember = (Member) session.getAttribute("member");
		Integer id = seMember.getId(); 
		member.setId(id);  //把取得的ID放進member

		boolean result = SERVICE.editMember(member); //把值傳給service
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
	}
	
	@Override  //回傳當前會員資料 從session拿出來
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入OPTIONS");
		HttpSession session = req.getSession(false);  //檢查是否有紀錄session
	    if (session != null) {
	        Member member = (Member) session.getAttribute("member");
			resp.getWriter().write(GSON.toJson(member.getId()));
	    } else { //session為null 回傳null
	    	resp.getWriter().write(GSON.toJson(null));
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", true);
		resp.getWriter().write(respBody.toString());
	}
}
