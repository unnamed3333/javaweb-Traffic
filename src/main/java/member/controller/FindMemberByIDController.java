package member.controller;

import static core.util.Constants.GSON;
import static member.util.MemberConstants.SERVICE;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.bean.Member;


@WebServlet("/FindMemberByID/*")
public class FindMemberByIDController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Member member = new Member();	
		HttpSession session = req.getSession();
		Member seMember = (Member) session.getAttribute("member");
		Integer id = seMember.getId(); 
		member = SERVICE.findMemberById(Integer.valueOf(id)); //把從前端取得的member傳進service
		String avatarBase64 = Base64.getEncoder().encodeToString(member.getAvatar()); //把blob轉成base64 而且要判斷NULL 梅圖匯出錯
		member.setAvatarBase64(avatarBase64); 
		resp.getWriter().write(GSON.toJson(member));
	}
}
