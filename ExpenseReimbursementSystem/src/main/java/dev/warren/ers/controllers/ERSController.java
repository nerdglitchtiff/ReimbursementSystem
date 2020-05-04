package dev.warren.ers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.warren.ers.entities.Employee;
import dev.warren.ers.entities.ReimReq;
import dev.warren.ers.entities.Staff;
import dev.warren.ers.services.ReqService;
import dev.warren.ers.services.ReqServiceI;
import dev.warren.ers.services.StaffService;
import dev.warren.ers.services.StaffServiceI;

public class ERSController {
	StaffServiceI ssi = new StaffService();
	ReqServiceI rsi = new ReqService();



	public void getAllRequests(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession sess = request.getSession();
		Staff x = (Staff) sess.getAttribute("staff");
		Staff s = ssi.retrieveStaffByUsrnm(x);
		if( x != null && x.getStatus() =='M' ) {
			Gson gson = new Gson();
			List<ReimReq> rr = rsi.retrieveAllReimReqs();
			try (
					PrintWriter pw = response.getWriter()){
				String json = gson.toJson(rr);
				pw.append(json);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}// else response.getWriter().append("You must login as a Manager to access this page.");
	}//getAll closure

	public void addReq(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession sess = request.getSession();
		Staff x = (Staff) sess.getAttribute("staff");
		System.out.println(x);
		if(x != null) {
			String body = request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
			Gson gson = new Gson();

			ReimReq rr = gson.fromJson(body, ReimReq.class);
			rsi.createReq(rr);
			response.getWriter().append("Reimbursement request submitted.");
		} else response.getWriter().append("You must login to access this page");

	}//add closure

	public void getReqById(HttpServletRequest request, HttpServletResponse response) throws IOException {

		
		HttpSession sess = request.getSession();
		Gson gson = new Gson();
		String body = request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
		ReimReq rr = gson.fromJson(body, ReimReq.class);
		int id = rr.getrId();
		String json = gson.toJson(rsi.retrieveReimReqById(id));
		response.getWriter().append(json);
		
		
		
	}//getById closure

	public void getAllByStat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Gson gson = new Gson();
		String body = request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
		ReimReq rr = gson.fromJson(body, ReimReq.class);
		String status = rr.getStatus();
		String json = gson.toJson(rsi.retrieveReimReqByStatus(status));
		response.getWriter().append(json);
	}

	public void getAllStatusId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Gson gson = new Gson();
		String body = request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
		ReimReq rr = gson.fromJson(body, ReimReq.class);
		String status = rr.getStatus();
		int id = rr.getEmpId();
		String json = gson.toJson(rsi.retrieveReimReqByStatusId(status, id));
		response.getWriter().append(json);
	}



	public void getAllDateId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Gson gson = new Gson();
		long d = Long.parseLong(request.getParameter("date"));
		java.sql.Date date=new java.sql.Date(d); 
		int id = (int) sess.getAttribute("staffId");
		String json = gson.toJson(rsi.retrieveReimReqByDateId(date, id));
		response.getWriter().append(json);
	}


	public void getAllDate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Gson gson = new Gson();
//		long d = Long.parseLong(request.getParameter("date"));//change to string b/c getParameter returns string. May need to parse date and change back to date in 
		//services, dao, and test
		String body = request.getReader().lines().reduce("", (accumulator,actual)->accumulator+actual);
		ReimReq rr = gson.fromJson(body, ReimReq.class);
//		System.out.println(rr.getReqDate());
//		java.sql.Date date= rr.getReqDate();
				//new java.sql.Date(d);  

		String json = gson.toJson(rsi.retrieveReimReqByStatus(rr.getStatus()));
		response.getWriter().append(json);
	}

	public void getAllMgrId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Gson gson = new Gson();
		int id = (int) sess.getAttribute("staffId");
		String json = gson.toJson(rsi.retrieveReimReqByMgrId(id));
		response.getWriter().append(json);
	}

	public void getAllEmpId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Staff x = (Staff)sess.getAttribute("staff");
		if(x != null) {
		Gson gson = new Gson();
		int id = x.getEmpdId();
		String json = gson.toJson(rsi.retrieveReimReqByMgrId(id));
		response.getWriter().append(json);
		} else response.getWriter().append("You have to login to see this page.");
	}

	public void updateReq(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Staff m = (Staff)sess.getAttribute("Staff");
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		System.out.println(json);
		ReimReq rr = gson.fromJson(json, ReimReq.class);
		rsi.updateReq(rr);
		System.out.println(rr);
		response.getWriter().append("Successfully updated request!!!!");		
	}

	public void getStaffByUsrnm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Staff s = (Staff)gson.fromJson(body, Employee.class);
		Staff st = ssi.retrieveStaffByUsrnm(s);
		if(st != null){
			sess.setAttribute("staff", st);
			response.getWriter().append(gson.toJson(st));
		}
		else  response.sendRedirect("http://localhost:8080/ExpenseReimbursementSystem/");
	}

	public void signout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();

		sess.invalidate(); 
		
	}

	public void removeReq(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		Gson gson = new Gson();
		String json = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		ReimReq rr = gson.fromJson(json, ReimReq.class);
		ReimReq r = rsi.retrieveReimReqById(rr.getrId());
		boolean res = rsi.removeReimReq(r);
		if(res) 
			response.getWriter().append("Error, request not removed."); 
		else response.getWriter().append("Successfully removed request!");

	}







}//controller closure
