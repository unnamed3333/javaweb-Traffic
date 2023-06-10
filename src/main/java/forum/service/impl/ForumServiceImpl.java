package forum.service.impl;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import core.bean.ForumArticle;
import core.bean.ForumComment;
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

	@Override
	public List<ForumArticle> findArticle() {
		return dao.findArticle();
	}

	@Override
	public boolean editArticle(ForumArticle forumArticle) {
		int result = dao.editAeticle(forumArticle);
		return result > 0;
	}

	@Override
	public boolean addComment(ForumComment forumComment, Integer id) {
		int result = dao.insertComment(forumComment,id);
		return result > 0;
	}

	@Override
	public List<ForumComment> findComment(Integer id) {
		return dao.findComment(id);
	}

	@Override
	public boolean editComment(ForumComment forumComment) {
		int result = dao.editComment(forumComment);
		return result > 0;
	}
	
	
}

