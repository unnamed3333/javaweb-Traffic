package whistleblower.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import whistleblower.model.Whistleblower;
import whistleblower.service.WhistleblowerService;
import whistleblower.service.impl.WhistleblowerServiceImpl;

@WebServlet("/whistleblower/*")
public class WhistleblowerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final WhistleblowerService SERIVCE = new WhistleblowerServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Whistleblower whistleblower = GSON.fromJson(req.getReader(), Whistleblower.class);  //接收前端的資料
		System.out.println(whistleblower);  //print
		boolean result = SERIVCE.addOneWhistleblower(whistleblower);  //把值傳給service

		JsonObject respBody = new JsonObject();
		respBody.addProperty("successful", result); // 把service傳回來的值放進successful
		resp.getWriter().write(respBody.toString()); // 把上面respBody 加進的東西 傳回前端

	}

}
