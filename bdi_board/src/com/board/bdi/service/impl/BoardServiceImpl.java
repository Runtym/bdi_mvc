package com.board.bdi.service.impl;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.board.bdi.common.DBCon;
import com.board.bdi.common.ParseUtil;
import com.board.bdi.common.UploadFiles;
import com.board.bdi.dao.BoardDAO;
import com.board.bdi.dao.impl.BoardDAOImpl;
import com.board.bdi.service.BoardService;
import com.board.bdi.vo.BoardInfoVO;
import com.board.bdi.vo.CommentInfoVO;

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
		BoardInfoVO bi = ParseUtil.parseRequest(req, BoardInfoVO.class);
		bdao.setCon(DBCon.getCon());
		try {
			bdao.updateBoardCnt(bi);
			CommentInfoVO ci = new CommentInfoVO();
			ci.setBinum(bi.getBinum());
			req.setAttribute("ciList", bdao.selectCommentList(ci));
			req.setAttribute("bi", bdao.selectBoard(bi));
			DBCon.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public void insertBoard(HttpServletRequest req) throws SQLException, ServletException {
		Map<String,String> params = UploadFiles.saveFileList(req);
		BoardInfoVO bi = new BoardInfoVO();
		bi.setBititle(params.get("bititle"));
		bi.setBitext(params.get("bitext"));
		bi.setBifile(params.get("bifile"));
		bi.setUinum(Integer.parseInt(params.get("uinum")));
		System.out.println(bi);
		bdao.setCon(DBCon.getCon());
		try {
			req.setAttribute("cnt", bdao.insertBoard(bi));
			DBCon.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public void updateBoard(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectCommentList(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectComment(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertComment(HttpServletRequest req) throws SQLException, ServletException {
		CommentInfoVO ci = ParseUtil.parseRequest(req, CommentInfoVO.class);
		bdao.setCon(DBCon.getCon());
		try {
			BoardInfoVO bi = new BoardInfoVO();
			bi.setBinum(ci.getBinum());
			req.setAttribute("bi", bdao.selectBoard(bi));
			req.setAttribute("ciCnt", bdao.insertCommment(ci));
			req.setAttribute("ciList", bdao.selectCommentList(ci));
			DBCon.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public void deleteComment(HttpServletRequest req) throws SQLException, ServletException {
		CommentInfoVO ci = ParseUtil.parseRequest(req, CommentInfoVO.class);
		bdao.setCon(DBCon.getCon());
		try {
			BoardInfoVO bi = new BoardInfoVO();
			bi.setBinum(ci.getBinum());
			req.setAttribute("ciDelCnt", bdao.deleteComment(ci));
			req.setAttribute("bi", bdao.selectBoard(bi));
			req.setAttribute("ciList", bdao.selectCommentList(ci));
			DBCon.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		
	}

}
