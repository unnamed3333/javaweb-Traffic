package core.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Vehide implements Serializable {
	private static final long serialVersionUID = -755115136250492823L;
	private String vehideType;  //帳號
	private String vehideNumber;  //密碼
	public String getVehideNumber() {
		return vehideNumber;
	}
	public void setVehideNumber(String vehideNumber) {
		this.vehideNumber = vehideNumber;
	}
	public String getVehideType() {
		return vehideType;
	}
	public void setVehideType(String vehideType) {
		this.vehideType = vehideType;
	}
	
}
