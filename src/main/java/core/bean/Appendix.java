package core.bean;

import java.io.Serializable;

public class Appendix implements Serializable {
	private static final long serialVersionUID = 1L;
	    private Integer ID; // ID
	    private Integer messageID; // MessageID
	    private Integer articleID; // ArticleID
	    private Integer whistleblowerFormID; // WhistleblowerFormID
	    private String ticketNo; // TicketNo
	    private byte[] appendix; // Appendix
	    private String appendixBase64;
	    
		public Integer getID() {
			return ID;
		}
		public void setID(Integer iD) {
			ID = iD;
		}
		public Integer getMessageID() {
			return messageID;
		}
		public void setMessageID(Integer messageID) {
			this.messageID = messageID;
		}
		public Integer getArticleID() {
			return articleID;
		}
		public void setArticleID(Integer articleID) {
			this.articleID = articleID;
		}
		public Integer getWhistleblowerFormID() {
			return whistleblowerFormID;
		}
		public void setWhistleblowerFormID(Integer whistleblowerFormID) {
			this.whistleblowerFormID = whistleblowerFormID;
		}
		public String getTicketNo() {
			return ticketNo;
		}
		public void setTicketNo(String ticketNo) {
			this.ticketNo = ticketNo;
		}
		public byte[] getAppendix() {
			return appendix;
		}
		public void setAppendix(byte[] appendix) {
			this.appendix = appendix;
		}
		public String getAppendixBase64() {
			return appendixBase64;
		}
		public void setAppendixBase64(String appendixBase64) {
			this.appendixBase64 = appendixBase64;
		}
}
