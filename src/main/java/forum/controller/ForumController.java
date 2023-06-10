package forum.controller;

import static core.util.Constants.GSON;
import static forum.util.ForumConstants.SERVICE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import core.bean.ForumArticle;
import core.bean.Member;
import core.bean.RelatedPerson;


@WebServlet("/ForumArticle/*")
public class ForumController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//新增文章
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入Forum POST");
		
		HttpSession session = req.getSession();
		Member Member = (Member) session.getAttribute("member");
		Integer id = Member.getId(); 
		
		ForumArticle forumArticle = GSON.fromJson(req.getReader(), ForumArticle.class); //接收前端資料
		boolean result = SERVICE.addArticle(forumArticle, id); //把值傳給service
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result); //把service傳回來的值放進successful
		resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
	}
	
	//查詢文章
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入Forum GET");

//		HttpSession session = req.getSession();
//		Member Member = (Member) session.getAttribute("member");
//		Integer id = Member.getId(); 

		List<ForumArticle> forumArticles = new ArrayList<>();
		forumArticles =	SERVICE.findArticle();
		resp.getWriter().write(GSON.toJson(forumArticles));
	}
	
	//編輯文章
		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("進入Forum PUT");
			ForumArticle forumArticle = GSON.fromJson(req.getReader(), ForumArticle.class); //接收前端資料
//			//這3行取得登入的人的ID
//			HttpSession session = req.getSession();
//			Member seMember = (Member) session.getAttribute("member");
//			Integer id = seMember.getId(); 
//			relatedPerson.setId(id);  //把取得的ID放進member

			boolean result = SERVICE.editArticle(forumArticle); //把值傳給service
			JsonObject respBody = new JsonObject();
			respBody.addProperty("successful", result);
			resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
		}
}
