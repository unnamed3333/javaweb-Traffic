package member.controller;

import static core.util.Constants.GSON;
import static member.util.MemberConstants.SERVICE;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.bean.Member;
import core.bean.Vehide;


@WebServlet("/Vehide/*")
public class VehideController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Member seMember = (Member) session.getAttribute("member");
		Integer id = seMember.getId(); 
		
		String pathInfo = req.getPathInfo(); //取得網址後面帶的值
		pathInfo = pathInfo.substring(1); //去掉開頭的斜線
		String[] pathVariables = pathInfo.split("/"); //把網址拆成陣列 [0]==0是會員 [0]==1是關係人 是關係人的話 後面還有[1] 這是關係人ID
		List<Vehide> list = new ArrayList<>();
		if (pathVariables[0].equals("0")) { //1是會員 2是關係人
			list = SERVICE.vihide(1, id);
		}else {
			list = SERVICE.vihide(2, Integer.parseInt(pathVariables[1])); //
		}
		resp.getWriter().write(GSON.toJson(list));
	}
}
