package forum.dao;

import core.bean.ForumArticle;

public interface ForumDao {

	int insertArticle(ForumArticle forumArticle, Integer id);
	
	
}
