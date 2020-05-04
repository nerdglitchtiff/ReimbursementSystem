package dev.warren.ers.entities;

import java.sql.Date;

public class ReimReq {
	private int rId;
	private double amt;
	private double amtApproved = 0;  
	private int empId;
	private String status = "pending";
	private int mgId;
	private long millis=System.currentTimeMillis();  
	private Date reqDate = new java.sql.Date(millis); 
	private Date appDate;
	private String details;
	


	public ReimReq() {
		super();
	}
	
	

	public ReimReq(int rId, double amt, double amtApproved, int empId, String status, int mgId, Date reqDate,
			Date appDate, String details) {
		super();
		this.rId = rId;
		this.amt = amt;
		this.amtApproved = amtApproved;
		this.empId = empId;
		this.status = status;
		this.mgId = mgId;
		this.reqDate = reqDate;
		this.appDate = appDate;
		this.details = details;
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

	public void setAppDate() {
		long millis=System.currentTimeMillis();  
		 
		this.appDate = new java.sql.Date(millis); 
	}
	
	public void setAppDate( Date appDate) {
	 
		 
		this.appDate = appDate;
	}

	public Date getReqDate() {
		return reqDate;
	}

	
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}









}//class closure
