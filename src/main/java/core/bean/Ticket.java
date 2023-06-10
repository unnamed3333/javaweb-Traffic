package core.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
    private String ticketNo; // 罰單編號
    private Integer memID; // 會員號碼
    private String driver; // 違規駕駛(行為)人
    private String phoneNo; // 電話
    private String vehicleNo; // 車號
    private String vehicleType; // 車輛種類
    private Timestamp violationsTime; // 違規時間
    private String violationsAddress; // 違規地點
    private String violations; // 違規事項
    private String reportingRegulations; // 舉發條例
    private Integer amount; // 違規金額
    private Timestamp paymentDueDate; // 繳納到期日
    private String police; // 員警
    private String unit; // 單位
    private Integer status; // 0=未繳納、1=已繳納、2=申訴中、3=申訴成功
    private Timestamp paymentTime; // 繳納時間
    private List<byte[]> Appendix; // 附件list
	
    public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public Integer getMemID() {
		return memID;
	}
	public void setMemID(Integer memID) {
		this.memID = memID;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Timestamp getViolationsTime() {
		return violationsTime;
	}
	public void setViolationsTime(Timestamp violationsTime) {
		this.violationsTime = violationsTime;
	}
	public String getViolationsAddress() {
		return violationsAddress;
	}
	public void setViolationsAddress(String violationsAddress) {
		this.violationsAddress = violationsAddress;
	}
	public String getViolations() {
		return violations;
	}
	public void setViolations(String violations) {
		this.violations = violations;
	}
	public String getReportingRegulations() {
		return reportingRegulations;
	}
	public void setReportingRegulations(String reportingRegulations) {
		this.reportingRegulations = reportingRegulations;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Timestamp getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(Timestamp paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	public String getPolice() {
		return police;
	}
	public void setPolice(String police) {
		this.police = police;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Timestamp paymentTime) {
		this.paymentTime = paymentTime;
	}
	public List<byte[]> getAppendix() {
		return Appendix;
	}
	public void setAppendix(List<byte[]> appendix) {
		Appendix = appendix;
	}
}
