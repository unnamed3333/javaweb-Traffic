package core.bean;

import java.sql.Timestamp;

public class Chat {
	private static final long serialVersionUID = 1L;

    private Integer ID; // ID
    private Integer senderID; // 傳送者ID
    private Integer chatroomID; // 聊天室UID
	private String content; // 內容
	private byte[] appendix; // 附件
    private Timestamp sendTime; // 傳送時間
    private boolean readStatus; // 已讀狀態
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getSenderID() {
		return senderID;
	}
	public void setSenderID(Integer senderID) {
		this.senderID = senderID;
	}
	public Integer getChatroomID() {
		return chatroomID;
	}
	public void setChatroomID(Integer chatroomID) {
		this.chatroomID = chatroomID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte[] getAppendix() {
		return appendix;
	}
	public void setAppendix(byte[] appendix) {
		this.appendix = appendix;
	}
	public Timestamp getSendTime() {
		return sendTime;
	}
	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}
	public boolean isReadStatus() {
		return readStatus;
	}
	public void setReadStatus(boolean readStatus) {
		this.readStatus = readStatus;
	}

}
