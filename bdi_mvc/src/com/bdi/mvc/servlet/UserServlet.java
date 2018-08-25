package com.bdi.mvc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.UserService;
import com.bdi.mvc.service.impl.UserServiceImpl;
import com.bdi.mvc.vo.User;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("userList")) {
			List<User> userList = us.getUserList(null);
			request.setAttribute("list", userList);
		}else if(cmd.equals("userView") || cmd.equals("userUpdate")) {
			String mNumStr = request.getParameter("mNum");
			if(mNumStr==null) {
				request.setAttribute("msg","메이커 넘버 없이 화면 요청은 불가능 합니다.");
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			int mNum = Integer.parseInt(mNumStr);
			request.setAttribute("user", us.getUser(mNum));
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
