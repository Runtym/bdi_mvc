package com.bdi.mvc.vo;

public class Maker {
	private int mnum;
	private String mname;
	private int mprice;
	private int mcnt;
	private int mtotal;
	private String mdesc;
	public Maker(int mnum, String mname, int mprice, int mcnt, int mtotal, String mdesc) {
		super();
		this.mnum = mnum;
		this.mname = mname;
		this.mprice = mprice;
		this.mcnt = mcnt;
		this.mtotal = mtotal;
		this.mdesc = mdesc;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMprice() {
		return mprice;
	}
	public void setMprice(int mprice) {
		this.mprice = mprice;
	}
	public int getMcnt() {
		return mcnt;
	}
	public void setMcnt(int mcnt) {
		this.mcnt = mcnt;
	}
	public int getMtotal() {
		return mtotal;
	}
	public void setMtotal(int mtotal) {
		this.mtotal = mtotal;
	}
	public String getMdesc() {
		return mdesc;
	}
	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}
	@Override
	public String toString() {
		return "Maker [mnum=" + mnum + ", mname=" + mname + ", mprice=" + mprice + ", mcnt=" + mcnt + ", mtotal="
				+ mtotal + ", mdesc=" + mdesc + "]";
	}
	
}
