package forum.service;

import java.util.List;

import core.bean.ForumArticle;
import core.bean.ForumComment;

public interface ForumService {

	boolean addArticle(ForumArticle forumArticle, Integer id);

	List<ForumArticle> findArticle();

	boolean editArticle(ForumArticle forumArticle);

	boolean addComment(ForumComment forumComment, Integer id);

	List<ForumComment> findComment(Integer id);

	boolean editComment(ForumComment forumComment);


}
