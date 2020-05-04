package dev.warren.ers.services;

import java.sql.Date;
import java.util.List;

import dev.warren.ers.daos.ReqDAO;
import dev.warren.ers.daos.ReqDAOI;
import dev.warren.ers.entities.ReimReq;

public class ReqService implements ReqServiceI{
	ReqDAOI rdao = new ReqDAO();

	@Override
	public ReimReq createReq(ReimReq req) {
		return rdao.insertReq(req);
	}

	@Override
	public ReimReq retrieveReimReqById(int rId) {
		// TODO Auto-generated method stub
		return rdao.getReimReqById(rId);
	}

	@Override
	public List<ReimReq> retrieveReimReqByMgrId(int mgrId) {
		// TODO Auto-generated method stub
		return rdao.getReimReqByMgrId(mgrId);
	}

	@Override
	public List<ReimReq> retrieveReimReqByEmpId(int empId) {
		// TODO Auto-generated method stub
		return rdao.getReimReqByEmpId(empId);
	}

	@Override
	public List<ReimReq> retrieveReimReqByStatus(String status) {
		// TODO Auto-generated method stub
		return rdao.getReimReqByStatus(status);
	}

	@Override
	public List<ReimReq> retrieveReimReqByStatusId(String status, int empId) {
		// TODO Auto-generated method stub
		return rdao.getReimReqByStatusId(status, empId);
	}

	@Override
	public List<ReimReq> retrieveAllReimReqs() {
		// TODO Auto-generated method stub
		return rdao.getAllReimReqs();
	}

	@Override
	public ReimReq updateReq(ReimReq req) {
		// TODO Auto-generated method stub
		return rdao.updateReq(req);
	}

	@Override
	public boolean removeReimReq(ReimReq req) {
		boolean result = rdao.removeReimReq(req);
		return result;
	}

	@Override
	public List<ReimReq> retrieveReimReqByDateId(Date date, int empId) {
		// TODO Auto-generated method stub
		return rdao.getReimReqByDateId(date, empId);
	}

	@Override
	public List<ReimReq> retrieveReimReqByDate(Date date) {
		// TODO Auto-generated method stub
		return rdao.getReimReqByDate(date);
	}
	
	
	
	

}
