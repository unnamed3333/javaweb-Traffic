package whistleblower.model;

import java.sql.Date;
import java.sql.Time;

public class Whistleblower {

	private Integer whistleblowerNo;
	@Override
	public String toString() {
		return "Whistleblower [whistleblowerNo=" + whistleblowerNo + ", memID=" + memId + ", violations=" + violations
				+ ", violationsDate=" + violationsDate + ", violationsTime=" + violationsTime + ", violationsAddress="
				+ violationsAddress + ", vehicleType=" + vehicleType + ", vehicleNo=" + vehicleNo + ", remark=" + remark
				+ ", formCreateTime=" + formCreateTime + ", inspectorID=" + inspectorID + ", reportingRegulationsID="
				+ reportingRegulationsID + ", amount=" + amount + ", status=" + status + ", reviewTime=" + reviewTime
				+ "]";
	}
	private Integer memId;
    private String violations;  //違規種類
    private String violationsDate; //違規日期
    private String violationsTime;   //違規時間
    private String violationsAddress; //地點
    private String vehicleType;  //車種
    private String vehicleNo;  //車牌
    private String remark;     //地點備註
    private Date formCreateTime;
    private String inspectorID;
    private Integer reportingRegulationsID;
    private Integer amount;
    private Boolean status;
	private Date reviewTime;
	
	
	
	public Integer getWhistleblowerNo() {
		return whistleblowerNo;
	}
	public void setWhistleblowerNo(Integer whistleblowerNo) {
		this.whistleblowerNo = whistleblowerNo;
	}
	public Integer getMemID() {
		return memId;
	}
	public void setMemID(Integer memID) {
		this.memId = memID;
	}
	public String getViolations() {
		return violations;
	}
	public void setViolations(String violations) {
		this.violations = violations;
	}
	public String getViolationsDate() {
		return violationsDate;
	}
	public void setViolationsDate(String violationsDate) {
		this.violationsDate = violationsDate;
	}
	public String getViolationsTime() {
		return violationsTime;
	}
	public void setViolationsTime(String violationsTime) {
		this.violationsTime = violationsTime;
	}
	public String getViolationsAddress() {
		return violationsAddress;
	}
	public void setViolationsAddress(String violationsAddress) {
		this.violationsAddress = violationsAddress;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getFormCreateTime() {
		return formCreateTime;
	}
	public void setFormCreateTime(Date formCreateTime) {
		this.formCreateTime = formCreateTime;
	}
	public String getInspectorID() {
		return inspectorID;
	}
	public void setInspectorID(String inspectorID) {
		this.inspectorID = inspectorID;
	}
	public Integer getReportingRegulationsID() {
		return reportingRegulationsID;
	}
	public void setReportingRegulationsID(Integer reportingRegulationsID) {
		this.reportingRegulationsID = reportingRegulationsID;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
}
