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
import core.bean.RelatedPerson;
import core.bean.Vehide;


@WebServlet("/FindRelatedPerson/*")
public class FindRelatedPersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<RelatedPerson> relatedPersonList = new ArrayList<>();

		HttpSession session = req.getSession();
		Member Member = (Member) session.getAttribute("member");
		Integer id = Member.getId(); 
		relatedPersonList = SERVICE.findRelatedPerson(Integer.valueOf(id)); //把從前端取得的member傳進service
		resp.getWriter().write(GSON.toJson(relatedPersonList));
	}
}
