package forum.dao;

import java.util.List;

import core.bean.ForumArticle;
import core.bean.ForumComment;

public interface ForumDao {

	int insertArticle(ForumArticle forumArticle, Integer id);

	List<ForumArticle> findArticle();

	int editAeticle(ForumArticle forumArticle);

	int editComment(ForumComment forumComment);

	List<ForumComment> findComment(Integer id);

	int insertComment(ForumComment forumComment, Integer id);
	
	
}
