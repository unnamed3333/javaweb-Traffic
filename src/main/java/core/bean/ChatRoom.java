package core.bean;

public class ChatRoom {
	private static final long serialVersionUID = 1L;
    private Integer ID; // ID
    private Integer memID1; // 會員ID_1
    private Integer memID2; // 會員ID_2
    private String nickname; // 另外一個使用者的暱稱
    private byte[] avatar; // 另外一個使用者的頭貼
    private String avatarBase64;
    
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getMemID1() {
		return memID1;
	}
	public void setMemID1(Integer memID1) {
		this.memID1 = memID1;
	}
	public Integer getMemID2() {
		return memID2;
	}
	public void setMemID2(Integer memID2) {
		this.memID2 = memID2;
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
