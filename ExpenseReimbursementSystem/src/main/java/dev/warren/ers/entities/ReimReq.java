package dev.warren.ers.entities;

import java.util.Date;

public class ReimReq {
	private int rId;
	private double amt;
	private double amtApproved = 0;  
	private int empId;
	private String status = "pending";
	private int mgId;
	private Date appDate;


	public ReimReq() {
		super();
	}

	public int getrId() {
		return rId;
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

	public int getMgId() {
		return mgId;
	}
	public void setMgId(int mgId) {
		this.mgId = mgId;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public double getAmtApproved() {
		return amtApproved;
	}



	public void setAmtApproved(double amtApproved) {
		this.amtApproved = amtApproved;
	}


	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = java.util.Calendar.getInstance().getTime();  
	}

	@Override
	public String toString() {
		return " Request Id " + rId + ":  Amount Requested:" + amt + " Employee Id: " + empId + " Status: " + status + "Approving Manager: " + mgId
				+ "Amount Reimbursed: " + amtApproved;
	}







}//class closure
