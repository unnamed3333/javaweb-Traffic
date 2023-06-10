package core.bean;

import java.sql.Timestamp;

public class FineAppend {
	private static final long serialVersionUID = -755115136250492823L;

	private String ticketNo; // 理由
	private String reason; // 理由
	private String remark; // 補充
	
	
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
