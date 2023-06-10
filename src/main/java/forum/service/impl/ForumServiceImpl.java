package forum.service.impl;

import javax.servlet.annotation.WebServlet;

import core.bean.ForumArticle;
import forum.dao.ForumDao;
import forum.dao.impl.ForumDaoImpl;
import forum.service.ForumService;
import member.dao.impl.MemberDaoImpl;


@WebServlet("/ForumServiceImpl")
public class ForumServiceImpl implements ForumService {
	private ForumDao dao;
	
	public ForumServiceImpl() {
		dao = new ForumDaoImpl();
	}

	@Override
	public boolean addArticle(ForumArticle forumArticle, Integer id) {
		int result = dao.insertArticle(forumArticle,id);
		return result > 0;
	}
	
	
}

