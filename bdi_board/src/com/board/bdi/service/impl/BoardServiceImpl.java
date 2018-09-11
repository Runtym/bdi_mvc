package com.board.bdi.service.impl;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.board.bdi.common.DBCon;
import com.board.bdi.common.ParseUtil;
import com.board.bdi.dao.BoardDAO;
import com.board.bdi.dao.impl.BoardDAOImpl;
import com.board.bdi.service.BoardService;
import com.board.bdi.vo.BoardInfoVO;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();
	
	@Override
	public void selectBoardList(HttpServletRequest req) throws SQLException, ServletException {
		BoardInfoVO bi = ParseUtil.parseRequest(req, BoardInfoVO.class);
		bdao.setCon(DBCon.getCon());
		try {
			req.setAttribute("biList", bdao.selectBoardList(bi));
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public void selectBoard(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBoard(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoard(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

}
