package dev.warren.ers.services;

import java.util.List;
import dev.warren.ers.daos.StaffDAO;
import dev.warren.ers.daos.StaffDAOI;
import dev.warren.ers.entities.Staff;

public class StaffService implements StaffServiceI{
	StaffDAOI sdao = new StaffDAO();

	@Override
	public Staff retrieveStaffByUsrnm(Staff s) {
		Staff st = sdao.getStaffByUsrnm(s.getUsrnm());
		if(st != null) {
			if(!s.equals(st)) {
				st = null;
			}
		}
		return st;
	}// byId closure

	@Override
	public List<Staff> retrieveAllStaff() {
		// TODO Auto-generated method stub
		return null;
	}

}
