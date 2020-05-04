package dev.warren.ers.services;

import java.sql.Date;
import java.util.List;

import dev.warren.ers.entities.ReimReq;

public interface ReqServiceI {

	ReimReq createReq(ReimReq req); //

	ReimReq retrieveReimReqById(int rId);//
	
	List<ReimReq> retrieveReimReqByMgrId(int mgrId);//
	
	List<ReimReq> retrieveReimReqByEmpId(int empId);//

	List<ReimReq> retrieveReimReqByStatus(String status);//

	List<ReimReq> retrieveReimReqByStatusId(String status, int empId);//
	
	List<ReimReq> retrieveReimReqByDateId(Date date, int empId);//
	
	List<ReimReq> retrieveReimReqByDate(Date date);//

	List<ReimReq> retrieveAllReimReqs();//
	
	ReimReq updateReq(ReimReq req);//
	
	boolean removeReimReq(ReimReq req);//

}
