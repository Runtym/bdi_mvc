package com.board.bdi.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.bdi.service.BoardService;
import com.board.bdi.service.impl.BoardServiceImpl;


@WebServlet("/board/*")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uri;
	private BoardService bs = new BoardServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
			if(cmd.equals("boardList")) {
				bs.selectBoardList(request);
			}
		}catch(SQLException e){
			throw new ServletException("에러 : " + e.getMessage());
		}
		doService(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
}
