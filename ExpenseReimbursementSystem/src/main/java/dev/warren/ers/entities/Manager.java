package dev.warren.ers.entities;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Staff{

	public Manager() {
		super();

	}

	public Manager(int empdId, String fname, String lname, int mgrId, char status, String usrnm, String psswrd) {
		super(empdId, fname, lname, mgrId, status, usrnm, psswrd);

	}

	List<Staff> employees = new ArrayList<Staff>();
	List <ReimReq> reimReq = new ArrayList<ReimReq>();


	
}//class closure
