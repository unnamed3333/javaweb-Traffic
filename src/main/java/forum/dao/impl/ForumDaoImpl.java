package forum.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

import core.bean.ForumArticle;
import forum.dao.ForumDao;

public class ForumDaoImpl implements ForumDao{

	@Override
	public int insertArticle(ForumArticle forumArticle, Integer id) {
		final String sql = "insert into article(memid, content, title) "
				+ "values(?, ?, ?)";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setInt(1, id);//取得ID
			pstmt.setString(2, forumArticle.getContent());
			pstmt.setString(3, forumArticle.getTitle());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
}