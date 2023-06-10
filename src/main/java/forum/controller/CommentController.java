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
import core.bean.ForumComment;
import core.bean.Member;
import core.bean.RelatedPerson;


@WebServlet("/Comment/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//新增留言
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入Forum POST");
		
		HttpSession session = req.getSession();
		Member Member = (Member) session.getAttribute("member");
		Integer id = Member.getId(); 
		ForumComment forumComment = GSON.fromJson(req.getReader(), ForumComment.class);//接收前端資料
		boolean result = SERVICE.addComment(forumComment, id); //把值傳給service
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result); //把service傳回來的值放進successful
		resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
	}
	
	//查詢留言
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入Forum GET");

//		HttpSession session = req.getSession();
//		Member Member = (Member) session.getAttribute("member");
//		Integer id = Member.getId(); 
		String pathInfo = req.getPathInfo();  //取得網址後面帶的值 EX:member/1/2/3 拿到/1/2/3 但是拿到要拆開
		pathInfo = pathInfo.substring(1); //去掉/1/2/3 開頭的斜線 要不然拆要會多個空白
		String[] pathVariables = pathInfo.split("/"); //把1/2/3拆成陣列 0=第一個
		Integer id = Integer.parseInt(pathVariables[0]);
		List<ForumComment> forumComments = new ArrayList<>();
		forumComments =	SERVICE.findComment(id);
		resp.getWriter().write(GSON.toJson(forumComments));
	}
	
	//編輯留言
		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("進入Forum PUT");
			ForumComment forumComment = GSON.fromJson(req.getReader(), ForumComment.class); //接收前端資料
//			//這3行取得登入的人的ID
//			HttpSession session = req.getSession();
//			Member seMember = (Member) session.getAttribute("member");
//			Integer id = seMember.getId(); 
//			relatedPerson.setId(id);  //把取得的ID放進member

			boolean result = SERVICE.editComment(forumComment); //把值傳給service
			JsonObject respBody = new JsonObject();
			respBody.addProperty("successful", result);
			resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
		}
}
