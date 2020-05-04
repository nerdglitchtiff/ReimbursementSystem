package dev.warren.ers.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.warren.ers.daos.StaffDAO;
import dev.warren.ers.daos.StaffDAOI;
import dev.warren.ers.entities.Employee;
import dev.warren.ers.entities.Manager;
import dev.warren.ers.entities.Staff;

public class StaffDAOT {
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStaffByUsrnm() {
		StaffDAOI t = new StaffDAO();
		Staff g = new Manager();
		g.setUsrnm("tiffydidit");
		g.setPsswrd("1234567");
		g.setEmpdId(51);
		g.setFname("Tiffany");
		g.setLname("Warren");
		g.setStatus('M');
		g.setMgrId(55);
		
		Staff y =	t.getStaffByUsrnm("tiffydidit");
		System.out.println();
		System.out.println();
		boolean res = g.equals(y);
		System.out.println(res);
		
	}

}
