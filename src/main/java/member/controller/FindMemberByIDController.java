package member.controller;

import static core.util.Constants.GSON;
import static member.util.MemberConstants.SERVICE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.Member;


@WebServlet("/FindMemberByID/*")
public class FindMemberByIDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();  //取得網址後面帶的值 EX:member/1/2/3 拿到/1/2/3 但是拿到要拆開
		pathInfo = pathInfo.substring(1); //去掉/1/2/3 開頭的斜線 要不然拆要會多個空白
//		String[] pathVariables = pathInfo.split("/"); //把1/2/3拆成陣列 0=第一個
		Member member = new Member();	
		member = SERVICE.findMemberById(Integer.valueOf(pathInfo)); //把從前端取得的member傳進service

		resp.getWriter().write(GSON.toJson(member));
	}


}
