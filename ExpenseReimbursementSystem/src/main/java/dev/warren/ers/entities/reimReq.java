package dev.warren.ers.entities;

public class reimReq {
	private int rId;
	private double amt;
	private int empId;
	private boolean approved;
	private int mgId;
	public int getrId() {
		return rId;
	}
	
	
	
	public reimReq() {
		super();
	}



	public void setrId(int rId) {
		this.rId = rId;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public int getMgId() {
		return mgId;
	}
	public void setMgId(int mgId) {
		this.mgId = mgId;
	}
	
	

}
