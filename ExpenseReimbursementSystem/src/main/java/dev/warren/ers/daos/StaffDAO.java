package dev.warren.ers.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dev.warren.ers.entities.Employee;
import dev.warren.ers.entities.Manager;
import dev.warren.ers.entities.Staff;
import dev.warren.ers.utilities.ConnectionUtil;

public class StaffDAO implements StaffDAOI{

	@Override
	public Staff getStaffByUsrnm(String usrnm) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Staff s = null;
		try(Connection conn = ConnectionUtil.createConnection()){
				s = new Manager();
				ps = conn.prepareStatement(SSQL.GetStaffByUsrnm.getQuery());
				ps.setString(1, usrnm);
				rs = ps.executeQuery();
				rs.next();
				s.setEmpdId(rs.getInt("empdId"));
				s.setUsrnm(rs.getString("usrnm"));
				s.setPsswrd(rs.getString("psswrd"));
				s.setFname(rs.getString("fname"));
				s.setLname(rs.getString("lname"));	
				s.setStatus((char) rs.getInt("status"));
				s.setMgrId(rs.getInt("mgrId"));
			
		} catch (SQLException e) {
			e.printStackTrace();
			s = null;
		}
		return s;		
	}//
	
	
	

	@Override
	public List<Staff> getAllStaff() {
		Staff c;
		List<Staff> s = new ArrayList<Staff>();
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = null;
			ResultSet rs = null;

				ps = conn.prepareStatement(SSQL.GetAllStaff.getQuery());
				rs = ps.executeQuery();
				while(rs.next()){
					c = new Employee();
					c.setEmpdId(rs.getInt("empdId"));
					c.setUsrnm(rs.getString("usrnm"));
					c.setPsswrd(rs.getString("psswrd"));
					c.setFname(rs.getString("fname"));
					c.setLname(rs.getString("lname"));	
					s.add(c);
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}//
	
	
	
	
	

}//
