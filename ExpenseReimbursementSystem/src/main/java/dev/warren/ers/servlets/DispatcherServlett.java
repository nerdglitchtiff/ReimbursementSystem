package dev.warren.ers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.warren.ers.controllers.ERSController;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlett() {
		super();
		// TODO Auto-generated constructor stub
	}

	ERSController ecntrllr = new ERSController();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();

		switch(uri) {
		case"/ExpenseReimbursementSystem/api/login": ecntrllr.getStaffByUsrnm(request, response);
		break;
		case "/ExpenseReimbursementSystem/api/requests": ecntrllr.getAllRequests(request, response);//m
		break;
		case "/ExpenseReimbursementSystem/api/addrequest": ecntrllr.addReq(request, response);
		break;
		case "/ExpenseReimbursementSystem/api/getReqById": ecntrllr.getReqById(request, response);
		break;
		case "/ExpenseReimbursementSystem/api/bystatus": ecntrllr.getAllByStat(request, response);//m
		break;
		case "/ExpenseReimbursementSystem/api/bystatusid": ecntrllr.getAllStatusId(request, response);
		break;
		case "/ExpenseReimbursementSystem/api/bymgrid": ecntrllr.getAllMgrId(request, response);//m
		break;
		case "/ExpenseReimbursementSystem/api/byempid": ecntrllr.getAllEmpId(request, response);
		break;
		case "/ExpenseReimbursementSystem/api/updatereq": ecntrllr.updateReq(request, response);//m
		break;
		case "/ExpenseReimbursementSystem/api/bydate": ecntrllr.getAllDate(request, response);
		break;
		case "/ExpenseReimbursementSystem/api/bysdateid": ecntrllr.getAllDateId(request, response);
		break;
		case "/ExpenseReimbursementSystem/api/signout": ecntrllr.signout(request, response);
		break;
		case "/ExpenseReimbursementSystem/api/removereq": ecntrllr.removeReq(request, response);
		break;
		default: response.sendRedirect("http://localhost:8080/ExpenseReimbursementSystem/");
		break;
		}



		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
