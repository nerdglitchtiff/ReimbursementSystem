package dev.warren.ers.services;

import java.util.List;

import dev.warren.ers.entities.Staff;


public interface StaffServiceI {
	Staff retrieveStaffByUsrnm(Staff s);
	
	List<Staff> retrieveAllStaff();

}
