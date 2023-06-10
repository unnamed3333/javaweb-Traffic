package forum.controller;

import static core.util.Constants.GSON;
import static member.util.MemberConstants.SERVICE;

import java.io.IOException;

import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import core.bean.Member;
import core.bean.RelatedPerson;


@WebServlet("/Comment/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//新增關係人
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入Comment POST");
		
		HttpSession session = req.getSession();
		Member Member = (Member) session.getAttribute("member");
		Integer id = Member.getId(); 
		
		RelatedPerson relatedPerson = GSON.fromJson(req.getReader(), RelatedPerson.class); //接收前端資料
		boolean result = SERVICE.relatedPersonRegister(relatedPerson, id); //把值傳給service
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result); //把service傳回來的值放進successful
		resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
	}
	
	//查詢關係人
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("進入Comment GET");

		HttpSession session = req.getSession();
		Member Member = (Member) session.getAttribute("member");
		Integer id = Member.getId(); 

		List<RelatedPerson> relatedPersons = SERVICE.findRelatedPerson(id);
		relatedPersons.forEach(relatedPerson -> {
			if (relatedPerson.getAvatar() != null) {
				String avatarBase64 = Base64.getEncoder().encodeToString(relatedPerson.getAvatar()); //把blob轉成base64 判斷有沒有NULL 沒圖會出錯
				relatedPerson.setAvatarBase64(avatarBase64); 
			}
		});
		

		resp.getWriter().write(GSON.toJson(relatedPersons));
	}
	
	//編輯關係人資料
		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("進入Comment PUT");
			RelatedPerson relatedPerson = GSON.fromJson(req.getReader(), RelatedPerson.class); //接收前端資料
//			//這3行取得登入的人的ID
//			HttpSession session = req.getSession();
//			Member seMember = (Member) session.getAttribute("member");
//			Integer id = seMember.getId(); 
//			relatedPerson.setId(id);  //把取得的ID放進member

			boolean result = SERVICE.editRelatedPerson(relatedPerson); //把值傳給service
			JsonObject respBody = new JsonObject();
			respBody.addProperty("successful", result);
			resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
		}
}
