package com.board.bdi.service;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface BoardService {

	public void selectBoardList(HttpServletRequest req)throws SQLException, ServletException;
	public void selectBoard(HttpServletRequest req)throws SQLException, ServletException;
	
	public void insertBoard(HttpServletRequest req)throws SQLException, ServletException;
	public void updateBoard(HttpServletRequest req)throws SQLException, ServletException;
	public void deleteBoard(HttpServletRequest req)throws SQLException, ServletException;
}
