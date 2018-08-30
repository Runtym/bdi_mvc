package com.bdi.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.DepartService;
import com.bdi.mvc.service.impl.DepartServiceImpl;
import com.bdi.mvc.vo.Depart;

public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartService ds = new DepartServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
			if(cmd.equals("departList")) {
				request.setAttribute("departList",ds.selectDepartList(null));
			}else if(cmd.equals("departView")||cmd.equals("departUpdate")){
				String diNoStr = request.getParameter("diNo");
				Depart depart = new Depart();
				depart.setDiNo(Integer.parseInt(diNoStr));
				request.setAttribute("depart", ds.selectDepart(depart));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		try {
			if(cmd.equals("departInsert")) {
				String diName = request.getParameter("diName");
				String diDesc = request.getParameter("diDesc");
				Depart depart = new Depart(null, diName, diDesc, null);
				request.setAttribute("rMap", ds.insertDepart(depart));
			}else if(cmd.equals("departUpdate")) {
				String diName = request.getParameter("diName");
				String diDesc = request.getParameter("diDesc");
				Depart depart = new Depart(Integer.parseInt(request.getParameter("diNo")), diName, diDesc, null);
				request.setAttribute("rMap", ds.updateDepart(depart));
			}else if(cmd.equals("departDelete")) {
				Depart depart = new Depart(Integer.parseInt(request.getParameter("diNo")),
						null,null,null);
				request.setAttribute("rMap", ds.deleteDepart(depart));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
