package com.board.bdi.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.board.bdi.vo.BoardInfoVO;
import com.board.bdi.vo.CommentInfoVO;

public interface BoardDAO {
	public void setCon(Connection con);
	public int insertBoard(BoardInfoVO bi) throws SQLException;
	public int updateBoardCnt(BoardInfoVO bi) throws SQLException;
	public BoardInfoVO selectBoard(BoardInfoVO bi)throws SQLException;
	public List<BoardInfoVO> selectBoardList(BoardInfoVO bi)throws SQLException;
	
	public int insertCommment(CommentInfoVO ci)throws SQLException;	
	public CommentInfoVO selectComment(CommentInfoVO ci)throws SQLException;
	public List<CommentInfoVO> selectCommentList(CommentInfoVO ci)throws SQLException;	
}
