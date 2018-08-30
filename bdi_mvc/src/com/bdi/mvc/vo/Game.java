package com.bdi.mvc.vo;

public class Game {
	private Integer gcNum;
	private String gcName;
	private Integer gcPrice;
	private String gcVendor;
	private Integer gcOrder;
	private String gcDesc;
	private String gcImg;
	public Game() {}
	public Game(Integer gcNum, String gcName, Integer gcPrice, String gcVendor, Integer gcOrder, String gcDesc,
			String gcImg) {
		super();
		this.gcNum = gcNum;
		this.gcName = gcName;
		this.gcPrice = gcPrice;
		this.gcVendor = gcVendor;
		this.gcOrder = gcOrder;
		this.gcDesc = gcDesc;
		this.gcImg = gcImg;
	}
	public Integer getGcNum() {
		return gcNum;
	}
	public void setGcNum(Integer gcNum) {
		this.gcNum = gcNum;
	}
	public String getGcName() {
		return gcName;
	}
	public void setGcName(String gcName) {
		this.gcName = gcName;
	}
	public Integer getGcPrice() {
		return gcPrice;
	}
	public void setGcPrice(Integer gcPrice) {
		this.gcPrice = gcPrice;
	}
	public String getGcVendor() {
		return gcVendor;
	}
	public void setGcVendor(String gcVendor) {
		this.gcVendor = gcVendor;
	}
	public Integer getGcOrder() {
		return gcOrder;
	}
	public void setGcOrder(Integer gcOrder) {
		this.gcOrder = gcOrder;
	}
	public String getGcDesc() {
		return gcDesc;
	}
	public void setGcDesc(String gcDesc) {
		this.gcDesc = gcDesc;
	}
	public String getGcImg() {
		return gcImg;
	}
	public void setGcImg(String gcImg) {
		this.gcImg = gcImg;
	}
	@Override
	public String toString() {
		return "Game [gcNum=" + gcNum + ", gcName=" + gcName + ", gcPrice=" + gcPrice + ", gcVendor=" + gcVendor
				+ ", gcOrder=" + gcOrder + ", gcDesc=" + gcDesc + ", gcImg=" + gcImg + "]";
	}
	
}
