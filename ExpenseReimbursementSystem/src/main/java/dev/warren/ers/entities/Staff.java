package dev.warren.ers.entities;

public abstract class Staff {
	private int empdId;
	private String fname;
	private String lname;
	private int mgrId;
	private char status;
	private String usrnm;
	private String psswrd;
	
	public int getEmpdId() {
		return empdId;
	}


	public Staff() {
		super();
	}



	public Staff(int empdId, String fname, String lname, int mgrId, char status, String usrnm, String psswrd) {
		super();
		this.empdId = empdId;
		this.fname = fname;
		this.lname = lname;
		this.mgrId = mgrId;
		this.status = status;
		this.usrnm = usrnm;
		this.psswrd = psswrd;
	}



	public void setEmpdId(int empdId) {
		this.empdId = empdId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getMgrId() {
		return mgrId;
	}
	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public String getUsrnm() {
		return usrnm;
	}
	public void setUsrnm(String usrnm) {
		this.usrnm = usrnm;
	}
	public String getPsswrd() {
		return psswrd;
	}
	public void setPsswrd(String psswrd) {
		this.psswrd = psswrd;
	}



	@Override
	public String toString() {
		return "empdId=" + empdId + ", fname=" + fname + ", lname=" + lname + ", mgrId=" + mgrId + ", status="
				+ status + ", usrnm=" + usrnm + ", psswrd=" + psswrd;
	}



//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((psswrd == null) ? 0 : psswrd.hashCode());
//		result = prime * result + ((usrnm == null) ? 0 : usrnm.hashCode());
//		return result;
//	}



	public boolean equals(Staff obj) {
		boolean result = false;
		
			if( this.usrnm.equals(obj.getUsrnm()) && this.psswrd.equals(obj.getPsswrd()) ){
				result = true;
			}
		
		return result;

	}





}//class closure
