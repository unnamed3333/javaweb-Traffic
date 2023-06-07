package core.bean;

public class ChatRoom {
	private static final long serialVersionUID = 1L;
    private Integer ID; // ID
    private Integer memID1; // 會員ID_1
    private Integer memID2; // 會員ID_2
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
}
