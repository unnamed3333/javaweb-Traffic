package core.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class ForumComment implements Serializable {
	private static final long serialVersionUID = 1L;
	    private Integer ID; // ID
	    private Integer memberID; // memberID
	    private String content; // content
	    private Boolean status; // status
	    private Timestamp editTime; // editTime
	    private Timestamp createTime; // createTime
	    private Integer articleID; // articleID
	    
		public Integer getID() {
			return ID;
		}
		public void setID(Integer iD) {
			ID = iD;
		}
		public Integer getMemberID() {
			return memberID;
		}
		public void setMemberID(Integer memberID) {
			this.memberID = memberID;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}
		public Timestamp getEditTime() {
			return editTime;
		}
		public void setEditTime(Timestamp editTime) {
			this.editTime = editTime;
		}
		public Timestamp getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Timestamp createTime) {
			this.createTime = createTime;
		}
		public Integer getArticleID() {
			return articleID;
		}
		public void setArticleID(Integer articleID) {
			this.articleID = articleID;
		}

	    
	    
		
}
