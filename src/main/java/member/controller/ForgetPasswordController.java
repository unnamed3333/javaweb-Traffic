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

import com.google.gson.JsonObject;

import core.bean.Member;
import core.bean.Vehide;


@WebServlet("/ForgetPassword/*")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phoneNo = GSON.fromJson(req.getReader(), String.class); //接收前端資料
		boolean result = SERVICE.forgetPassword(phoneNo); //把值傳給service
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result); //把service傳回來的值放進successful
		resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = GSON.fromJson(req.getReader(), Member.class); //接收前端資料

		boolean result = SERVICE.resetPassword(member); //把值傳給service
		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result);
		resp.getWriter().write(respBody.toString());  //把上面respBody 加進的東西 傳回前端
	}
}
