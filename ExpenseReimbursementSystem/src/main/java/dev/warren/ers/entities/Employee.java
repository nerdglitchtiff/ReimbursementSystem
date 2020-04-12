package dev.warren.ers.entities;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Staff{

	public Employee() {
		super();
		
	}

	public Employee(int empdId, String fname, String lname, int mgrId, char status, String usrnm, String psswrd) {
		super(empdId, fname, lname, mgrId, status, usrnm, psswrd);
		
	}
	
	List <ReimReq> reimReq = new ArrayList<ReimReq>();
	
	

}
