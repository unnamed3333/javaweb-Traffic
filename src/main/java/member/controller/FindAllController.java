package member.controller;

import static core.util.CommonUtil.writeJsonBean;
import static member.util.MemberConstants.SERVICE;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login/findAll")
public class FindAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			writeJsonBean(resp, SERVICE.findAllMember());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
