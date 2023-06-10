package core.bean;

import java.sql.Timestamp;

public class Chat {
	private static final long serialVersionUID = 1L;
	private Integer ID; // ID
	private Integer senderID; // 傳送者ID
	private Integer chatroomID; // 聊天室UID
	private String content; // 內容
	private byte[] appendix; // 附件
	private String appendixBase64;
	private Timestamp sendTime; // 傳送時間
	private boolean readStatus; // 已讀狀態
	private Integer memId1;
	private Integer memId2;
	private String nickname; // 另外一個使用者的暱稱
	private byte[] avatar; // 另外一個使用者的頭貼
	private String avatarBase64;

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

	public String getAppendixBase64() {
		return appendixBase64;
	}

	public void setAppendixBase64(String appendixBase64) {
		this.appendixBase64 = appendixBase64;
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

	public Integer getMemId1() {
		return memId1;
	}

	public void setMemId1(Integer memId1) {
		this.memId1 = memId1;
	}

	public Integer getMemId2() {
		return memId2;
	}

	public void setMemId2(Integer memId2) {
		this.memId2 = memId2;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public String getAvatarBase64() {
		return avatarBase64;
	}

	public void setAvatarBase64(String avatarBase64) {
		this.avatarBase64 = avatarBase64;
	}
}
