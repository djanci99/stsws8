package org.ssis.edu.emp.model;

public class EmpDto {
	private String ssid;
	private String sspw;
	public EmpDto() {
		super();
	}
	public EmpDto(String ssid, String sspw) {
		super();
		this.ssid = ssid;
		this.sspw = sspw;
	}
	@Override
	public String toString() {
		return "EmpDto [ssid=" + ssid + ", sspw=" + sspw + "]";
	}
	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}
	public String getSspw() {
		return sspw;
	}
	public void setSspw(String sspw) {
		this.sspw = sspw;
	}
	
	
}
