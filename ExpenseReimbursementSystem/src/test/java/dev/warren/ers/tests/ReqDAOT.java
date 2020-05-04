package dev.warren.ers.tests;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dev.warren.ers.daos.ReqDAO;
import dev.warren.ers.daos.ReqDAOI;
import dev.warren.ers.entities.ReimReq;

public class ReqDAOT {

	static ReqDAOI rdao = new ReqDAO();
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
	public void testInsertReq() {
		ReimReq rr = new ReimReq();
		long millis=System.currentTimeMillis();  
		java.sql.Date d=new java.sql.Date(millis);    
		rr.setAmt(200);
		rr.setEmpId(3);
		rr.setReqDate(d);
		rr.setDetails("This is for the business lunch, with Astoria client, at BOA");
		rr.setMgId(53);
		ReimReq sr = rdao.insertReq(rr);
		//assert(rr.equals(sr));
		System.out.println(rr.getrId());
		System.out.println(sr.getrId());
		
		
		
	
		
		
	}

	@Test
	public void testGetReimReqById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReimReqByMgrId() {
		List<ReimReq> rr = rdao.getReimReqByMgrId(54);
		if(!rr.isEmpty()) System.out.println(rr.get(0).getrId());
	}

	@Test
	public void testGetReimReqByEmpId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReimReqByStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReimReqByStatusId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllReimReqs() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateReq() {
		ReimReq rr = rdao.getReimReqById(4);
		rr.setAmtApproved(100);
		long millis=System.currentTimeMillis();  
		java.sql.Date d=new java.sql.Date(millis); 
		rr.setAppDate(d);
		rr.setStatus("approved");
		ReimReq sr = rdao.updateReq(rr);
		System.out.println(sr.getStatus());
	}

	@Test
	public void testRemoveReimReq() {
		
		ReimReq sr = rdao.getReimReqById(4);
		boolean res = rdao.removeReimReq(sr);
		System.out.println(res);
	}

	@Test
	public void testGetReimReqByDateId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReimReqByDate() {
		long millis=System.currentTimeMillis();  
		java.sql.Date d=new java.sql.Date(millis);
		List<ReimReq> rr = rdao.getReimReqByDate(d);
		if(!rr.isEmpty()) System.out.println(rr.get(0).getrId());
	}

}
