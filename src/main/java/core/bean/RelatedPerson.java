package core.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class RelatedPerson implements Serializable {
	private static final long serialVersionUID = -755115136250492823L;
	private Integer id;  //關係人ID
	private String name;  //關係人名子
	private String identityNumber;  //身分證號碼
	private String birthday;  //生日
	private String memberRelationship;  //關係
	private String avatarBase64; //前端傳來的base64
	private byte[] avatar; //?
	
	
	public String getAvatarBase64() {
		return avatarBase64;
	}
	public void setAvatarBase64(String avatarBase64) {
		this.avatarBase64 = avatarBase64;
	}
	public byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMemberRelationship() {
		return memberRelationship;
	}
	public void setMemberRelationship(String memberRelationship) {
		this.memberRelationship = memberRelationship;
	}

	
	
	
}
