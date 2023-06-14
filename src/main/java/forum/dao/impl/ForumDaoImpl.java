package forum.dao.impl;

import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.When;

import core.bean.ForumArticle;
import core.bean.ForumComment;
import core.bean.Member;
import core.bean.RelatedPerson;
import forum.dao.ForumDao;

public class ForumDaoImpl implements ForumDao{

	@Override
	public int insertArticle(ForumArticle forumArticle, Integer id) {
		final String sql = "insert into article(memid, content, title)"
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

	@Override
	public List<ForumArticle> findArticle() {
		final String sql = "select * from article where Status = 0";
		List<ForumArticle> forumArticlesList = new ArrayList<>();
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					ForumArticle forumArticle = new ForumArticle();
					forumArticle.setMemberID(rs.getInt("MemID"));
					forumArticle.setContent(rs.getString("Content"));
					forumArticle.setTitle(rs.getString("Title"));
					forumArticle.setCreateTime(rs.getTimestamp("createtime"));
					forumArticlesList.add(forumArticle);
				}
				return forumArticlesList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public int editAeticle(ForumArticle forumArticle) {
		String sql = "update Member set Content = ?, Title = ?";
		
		//修改狀態
		Boolean Status = forumArticle.getStatus();
		if(Status != null) {sql += ", Status = ?";}
		sql += " where ID = ?";
		
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setString(1, forumArticle.getContent());
			pstmt.setString(2, forumArticle.getTitle() );
			if(Status != null) {
				pstmt.setBoolean(3, forumArticle.getStatus());
				pstmt.setInt(4, forumArticle.getID());
			} else {
				pstmt.setInt(3, forumArticle.getID());
			}
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	@Override
	public int insertComment(ForumComment forumComment, Integer id) {
		final String sql = "insert into message(MemID, Content, ArticleID)"
				+ "values(?, ?, ?)";
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setInt(1, id);//取得ID
			pstmt.setString(2, forumComment.getContent());
			pstmt.setInt(3, forumComment.getArticleID());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	

	@Override
	public List<ForumComment> findComment(Integer id) {
		final String sql = "select * from message where Status = 0";
		List<ForumComment> forumComments = new ArrayList<>();
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					ForumComment forumComment = new ForumComment();
					forumComment.setMemberID(rs.getInt("MemID"));
					forumComment.setContent(rs.getString("Content"));
					forumComment.setArticleID(rs.getInt("ArticleID"));
					forumComments.add(forumComment);
				}
				return forumComments;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public int editComment(ForumComment forumComment) {
		String sql = "update message set Content = ?";
		
		//修改狀態
		Boolean Status = forumComment.getStatus();
		if(Status != null) {sql += ", Status = ?";}
		sql += " where ID = ?";
		
		try (
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)
		) {
			pstmt.setString(1, forumComment.getContent());
			if(Status != null) {
				pstmt.setBoolean(2, forumComment.getStatus());
				pstmt.setInt(3, forumComment.getID());
			} else {
				pstmt.setInt(2, forumComment.getID());
			}
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}