package dev.warren.ers.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dev.warren.ers.entities.ReimReq;
import dev.warren.ers.utilities.ConnectionUtil;

public class ReqDAO implements ReqDAOI{

	@Override
	public ReimReq insertReq(ReimReq req) {

		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.InsertReim.getQuery(), Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setDouble(2, req.getAmt());
			ps.setDouble(3, 0);
			ps.setInt(4, req.getEmpId());
			ps.setString(5, req.getStatus());
			ps.setInt(6, req.getMgId());
			ps.setDate(7, (Date) req.getReqDate());
			ps.setDate(8, req.getAppDate());
			ps.setString(9, req.getDetails());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("rId");
			req.setrId(key);
		} catch (SQLException e) {
			e.printStackTrace();
			return req;
		}
		return req;
	}//insert closure

	@Override
	public ReimReq getReimReqById(int rId) {
		ReimReq rr = null;
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.GetReimById.getQuery());
			ps.setInt(1, rId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			rr = new ReimReq();
			rr.setrId(rId);
			rr.setAmt(rs.getDouble("amt"));
			rr.setAmtApproved(rs.getDouble("amtApproved"));
			rr.setEmpId(rs.getInt("empId"));
			rr.setStatus(rs.getString("status"));
			rr.setMgId(rs.getInt("appMgrId"));
			rr.setReqDate(rs.getDate("reqDate"));
			rr.setAppDate(rs.getDate("apprvDate"));
			rr.setDetails(rs.getString("details"));
			return rr;
		} catch (SQLException e) {
			e.printStackTrace();
			return rr;
		}	
	}//getById closure

	@Override
	public List<ReimReq> getReimReqByMgrId(int mgrId) {
		List<ReimReq> allM = new ArrayList<ReimReq>();
		ReimReq rr;
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.GetReimByMgrId.getQuery());
			ps.setInt(1, mgrId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rr = new ReimReq();
				rr.setrId(rs.getInt("rId"));
				rr.setAmt(rs.getDouble("amt"));
				rr.setAmtApproved(rs.getDouble("amtApproved"));
				rr.setEmpId(rs.getInt("empId"));
				rr.setStatus(rs.getString("status"));
				rr.setMgId(rs.getInt("appMgrId"));
				rr.setReqDate(rs.getDate("reqDate"));
				rr.setAppDate(rs.getDate("apprvDate"));
				rr.setDetails(rs.getString("details"));
				allM.add(rr);
			}
			return allM;
		} catch (SQLException e) {
			e.printStackTrace();
			return allM;
		}
	}//MgrId closure

	@Override
	public List<ReimReq> getReimReqByEmpId(int empId) {
		List<ReimReq> allI = new ArrayList<ReimReq>();
		ReimReq rr;
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.GetReimByEmpId.getQuery());
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rr = new ReimReq();
				rr.setrId(rs.getInt("rId"));
				rr.setAmt(rs.getDouble("amt"));
				rr.setAmtApproved(rs.getDouble("amtApproved"));
				rr.setEmpId(rs.getInt("empId"));
				rr.setStatus(rs.getString("status"));
				rr.setMgId(rs.getInt("appMgrId"));
				rr.setReqDate(rs.getDate("reqDate"));
				rr.setAppDate(rs.getDate("apprvDate"));
				rr.setDetails(rs.getString("details"));
				allI.add(rr);
			}
			return allI;
		} catch (SQLException e) {
			e.printStackTrace();
			return allI;
		}
	}//byEmpId closure

	@Override
	public List<ReimReq> getReimReqByStatus(String status) {
		List<ReimReq> allS = new ArrayList<ReimReq>();
		ReimReq rr;
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.GetAllByStatus.getQuery());
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rr = new ReimReq();
				rr.setrId(rs.getInt("rId"));
				rr.setAmt(rs.getDouble("amt"));
				rr.setAmtApproved(rs.getDouble("amtApproved"));
				rr.setEmpId(rs.getInt("empId"));
				rr.setStatus(rs.getString("status"));
				rr.setMgId(rs.getInt("appMgrId"));
				rr.setReqDate(rs.getDate("reqDate"));
				rr.setAppDate();
				rr.setDetails(rs.getString("details"));
				allS.add(rr);
			}
			return allS;
		} catch (SQLException e) {
			e.printStackTrace();
			return allS;
		}
	}//byStatus closure

	@Override
	public List<ReimReq> getReimReqByStatusId(String status, int empId) {
		List<ReimReq> allSI = new ArrayList<ReimReq>();
		ReimReq rr;
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.GetAllByStatusId.getQuery());
			ps.setString(1, status);
			ps.setInt(2, empId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rr = new ReimReq();
				rr.setrId(rs.getInt("rId"));
				rr.setAmt(rs.getDouble("amt"));
				rr.setAmtApproved(rs.getDouble("amtApproved"));
				rr.setEmpId(rs.getInt("empId"));
				rr.setStatus(rs.getString("status"));
				rr.setMgId(rs.getInt("appMgrId"));
				rr.setReqDate(rs.getDate("reqDate"));
				rr.setAppDate(rs.getDate("apprvDate"));
				rr.setDetails(rs.getString("details"));
				allSI.add(rr);
			}
			return allSI;
		} catch (SQLException e) {
			e.printStackTrace();
			return allSI;
		}
	}//getByStatusId closure

	@Override
	public List<ReimReq> getAllReimReqs() {
		List<ReimReq> all = new ArrayList<ReimReq>();
		ReimReq rr;
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.GetAllReim.getQuery());
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				rr = new ReimReq();
				rr.setrId(rs.getInt("rId"));
				rr.setAmt(rs.getDouble("amt"));
				rr.setAmtApproved(rs.getDouble("amtApproved"));
				rr.setEmpId(rs.getInt("empId"));
				rr.setStatus(rs.getString("status"));
				rr.setMgId(rs.getInt("appMgrId"));
				rr.setReqDate(rs.getDate("reqDate"));
				rr.setAppDate(rs.getDate("apprvDate"));
				rr.setDetails(rs.getString("details"));
				all.add(rr);
			}
			return all;
		} catch (SQLException e) {
			e.printStackTrace();
			return all;
		}
	}//getAll closure

	@Override
	public ReimReq updateReq(ReimReq req) {
		ReqDAOI rda = new ReqDAO();
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.UpdateReim.getQuery());
			req.setAppDate();
			ps.setDouble(1, req.getAmtApproved());
			ps.setString(2, req.getStatus());
			ps.setInt(3, req.getMgId());
			ps.setDate(4, (Date) req.getAppDate());
			ps.setInt(5, req.getrId());
			ps.execute();
			return req = rda.getReimReqById(req.getrId());
		} catch (SQLException e) {
			e.printStackTrace();
			return req;
		}	
	}//update closure

	@Override
	public boolean removeReimReq(ReimReq req) {
		boolean result = false;
//		if(req.getStatus() == "pending") {
			
			try(Connection conn = ConnectionUtil.createConnection()){
				PreparedStatement ps = conn.prepareStatement(RSQL.RemoveReim.getQuery());
				ps.setInt(1, req.getrId());
				result = ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				result = true;
			}	
//		} else {result = true; System.out.println("else"+req.getStatus());}

		return result;
	}//remove closure

	@Override
	public List<ReimReq> getReimReqByDateId(Date date, int empId) {
		List<ReimReq> allD = new ArrayList<ReimReq>();
		ReimReq rr;
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.GetByDateId.getQuery());
			ps.setDate(1, date);
			ps.setInt(2, empId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rr = new ReimReq();
				rr.setrId(rs.getInt("rId"));
				rr.setAmt(rs.getDouble("amt"));
				rr.setAmtApproved(rs.getDouble("amtApproved"));
				rr.setEmpId(rs.getInt("empId"));
				rr.setStatus(rs.getString("status"));
				rr.setMgId(rs.getInt("appMgrId"));
				rr.setReqDate(rs.getDate("reqDate"));
				rr.setAppDate(rs.getDate("apprvDate"));
				rr.setDetails(rs.getString("details"));
				allD.add(rr);
			}
			return allD;
		} catch (SQLException e) {
			e.printStackTrace();
			return allD;
		}
	}//DateId closure

	@Override
	public List<ReimReq> getReimReqByDate(Date date) {
		List<ReimReq> allDI = new ArrayList<ReimReq>();
		ReimReq rr;
		try(Connection conn = ConnectionUtil.createConnection()){
			PreparedStatement ps = conn.prepareStatement(RSQL.GetByDate.getQuery());
			ps.setDate(1, date);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rr = new ReimReq();
				rr.setrId(rs.getInt("rId"));
				rr.setAmt(rs.getDouble("amt"));
				rr.setAmtApproved(rs.getDouble("amtApproved"));
				rr.setEmpId(rs.getInt("empId"));
				rr.setStatus(rs.getString("status"));
				rr.setMgId(rs.getInt("appMgrId"));
				rr.setReqDate(rs.getDate("reqDate"));
				rr.setAppDate(rs.getDate("apprvDate"));
				rr.setDetails(rs.getString("details"));
				allDI.add(rr);
			}
			return allDI;
		} catch (SQLException e) {
			e.printStackTrace();
			return allDI;
		}
	}//date closure














}//class closure
