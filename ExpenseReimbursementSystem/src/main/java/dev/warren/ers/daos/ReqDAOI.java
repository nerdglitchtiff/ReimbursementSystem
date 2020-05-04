package dev.warren.ers.daos;

import java.sql.Date;
import java.util.List;

import dev.warren.ers.entities.ReimReq;


public interface ReqDAOI {
	enum RSQL{
		GetAllReim("select * from ReimbReq"),//
		GetReimById("select * from ReimbReq where rId = ?"),//
		InsertReim("insert into ReimbReq values(?,?,?,?,?,?,?,?,?)"),//
		GetReimByEmpId("select * from ReimbReq where empId = ?"),//for emp
		GetReimByMgrId("SELECT * from ReimbReq r where r.empId in (select s.empdId from Staff s where s.mgrId = ?)"),//for mgr
		GetAllByStatus("select * from ReimbReq where status = ? order by reqDate"),//
		GetByDate("select * from ReimbReq where reqDate = ? order by reqDate"),
		GetAllByStatusId("select * from ReimbReq where status = ? and empId = ? order by reqDate"),//
		GetByDateId("select * from ReimbReq where reqDate = ? and empId = ? order by reqDate"),//employee only
		RemoveReim("delete from ReimbReq where rId = ?"),//
		UpdateReim("update ReimbReq set amtApproved=?, status=?, appMgrId=?, apprvDate=? where rId = ?");//

		private final String query;
		private RSQL(String q) {
			this.query = q;
		}
		public String getQuery() {
			return query;
		}
	}//enum closure
	
	/**
	 * Inserts ReimReq into Db
	 * @return ReimReq
	 * @param ReimReq
	 */
	ReimReq insertReq(ReimReq req); //
	
	/**
	 * Queries db for single req.
	 * @return ReimReq
	 * @param rId ReimReq id
	 */
	ReimReq getReimReqById(int rId);//
	
	/**
	 * @return List of ReimReq objs.
	 * @param mgrId Manager id
	 */
	List<ReimReq> getReimReqByMgrId(int mgrId);//
	
	/**
	 * @return List of ReimReq objs.
	 * @param empId Employee id
	 */
	List<ReimReq> getReimReqByEmpId(int empId);//
	
	/**
	 * @return List of ReimReq objs.
	 * @param status ReimReq status
	 */
	List<ReimReq> getReimReqByStatus(String status);//
	
	/**
	 * @return List of ReimReq objs.
	 * @param status ReimReq status
	 * @param empId Employee id
	 */
	List<ReimReq> getReimReqByStatusId(String status, int empId);//
	
	/**
	 * @return List of ReimReq objs.
	 */
	List<ReimReq> getAllReimReqs();//
	
	/**
	 * @return List of ReimReq objs.
	 * @param Date ReimReq reqDate
	 * @param empId Employee id
	 */
	List<ReimReq> getReimReqByDateId(Date date, int empId);//
	
	/**
	 * @return List of ReimReq objs.
	 * @param Date ReimReq reqDate
	 */
	List<ReimReq> getReimReqByDate(Date date);//
	
	/**
	 * @return ReimReq to be updated
	 * @param ReimReq updated
	 */
	ReimReq updateReq(ReimReq req);//
	
	/**
	 * @return boolean
	 * @param ReimReq
	 */
	boolean removeReimReq(ReimReq req);//
	

	

}
