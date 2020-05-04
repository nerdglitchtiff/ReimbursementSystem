package dev.warren.ers.daos;

import java.util.List;

import dev.warren.ers.entities.Staff;



public interface StaffDAOI {
	enum SSQL{
		GetAllStaff("select * from Staff"),
		GetStaffByUsrnm("select * from Staff where usrnm = ?");
		private final String query;
		private SSQL(String q) {
			this.query = q;
		}
		public String getQuery() {
			return query;
		}

	}//enum closure


	/**
	 * Queries db for single Staff.
	 * @return Staff
	 * @param usrnm Staff usrnm
	 */
	Staff getStaffByUsrnm(String usrnm);

	/**
	 * @return List of Staff objs.
	 */
	List<Staff> getAllStaff();	
	
}//interface closure
