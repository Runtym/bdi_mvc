package com.bdi.mvc.vo;

public class User {

	private Long uiNo;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private String uiDesc;
	private int uiAge;
	private Long diNo;
	public User() {}
	public User(Long uiNo, String uiName, String uiId, String uiPwd, String uiDesc, int uiAge, Long diNo) {
		super();
		this.uiNo = uiNo;
		this.uiName = uiName;
		this.uiId = uiId;
		this.uiPwd = uiPwd;
		this.uiDesc = uiDesc;
		this.uiAge = uiAge;
		this.diNo = diNo;
	}
	public Long getUiNo() {
		return uiNo;
	}
	public void setUiNo(Long uiNo) {
		this.uiNo = uiNo;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	public String getUiPwd() {
		return uiPwd;
	}
	public void setUiPwd(String uiPwd) {
		this.uiPwd = uiPwd;
	}
	public String getUiDesc() {
		return uiDesc;
	}
	public void setUiDesc(String uiDesc) {
		this.uiDesc = uiDesc;
	}
	public int getUiAge() {
		return uiAge;
	}
	public void setUiAge(int uiAge) {
		this.uiAge = uiAge;
	}
	public Long getDiNo() {
		return diNo;
	}
	public void setDiNo(Long diNo) {
		this.diNo = diNo;
	}
	@Override
	public String toString() {
		return "User [uiNo=" + uiNo + ", uiName=" + uiName + ", uiId=" + uiId + ", uiPwd=" + uiPwd + ", uiDesc="
				+ uiDesc + ", uiAge=" + uiAge + ", diNo=" + diNo + "]";
	}
	
}
