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
	
	public void selectCommentList(HttpServletRequest req)throws SQLException, ServletException;
	public void selectComment(HttpServletRequest req)throws SQLException, ServletException;
	public void insertComment(HttpServletRequest req)throws SQLException, ServletException;
	public void deleteComment(HttpServletRequest req)throws SQLException, ServletException;
}
