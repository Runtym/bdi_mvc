package com.bdi.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.DelService;
import com.bdi.mvc.service.impl.DelServiceImpl;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DelService ds = new DelServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		
		try {
			if(cmd.equals("userList")) {
				List<Map<String, String>> list = ds.getDelList();
				request.setAttribute("list",list);
			}else if(cmd.equals("userView")) {
				int num = Integer.parseInt(request.getParameter("num"));
				request.setAttribute("user", ds.getDel(num));
			}else if(cmd.equals("userInsert")) {
				String name = request.getParameter("name");
				String age = request.getParameter("age");
				request.setAttribute("cnt", ds.insertDel(name, age));
			}else if(cmd.equals("userUpdate")) {
				String name = request.getParameter("name");
				String age = request.getParameter("age");
				int num = Integer.parseInt(request.getParameter("num"));
				if(name!=null && age!=null) {
					request.setAttribute("cnt", ds.updateDel(num, name, age));
				}
				request.setAttribute("user", ds.getDel(num));
			}else if(cmd.equals("userDelete")) {
				String[] nums = request.getParameterValues("num");
				List<Map<String,String>> list = ds.deleteDels(nums);
				request.setAttribute("list", list);
				uri = "/views/user/userList";
			}else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
