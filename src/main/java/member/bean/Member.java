package member.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Member implements Serializable {
	private static final long serialVersionUID = -755115136250492823L;
	private Integer id;  //使用者ID
	private String username;  //帳號
	private String password;  //密碼
	private String nickname;  //暱稱
	private String identityNumber;  //身分證號碼
	private String birthday;  //生日
	private String phoneNo;  //手機號碼
	private String address;  //地址
	private String email;  //email
	private String avatar;  //頭像型態不知道用啥 之後老師上課會教
    private Boolean forumPermissions;
    private Boolean  chatPermissions;
	private Timestamp createDateTime;  //建立時間
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Timestamp getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}
	
}
