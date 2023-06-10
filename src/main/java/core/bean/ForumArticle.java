package core.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class ForumArticle implements Serializable {
	private static final long serialVersionUID = 1L;
	    private Integer ID; // ID
	    private Integer memberID; // memberID
	    private String content; // content
	    private Boolean status; // status
	    private Timestamp editTime; // editTime
	    private Timestamp createTime; // createTime
	    private String title; //title
	    
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
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	    
	    
		
}
