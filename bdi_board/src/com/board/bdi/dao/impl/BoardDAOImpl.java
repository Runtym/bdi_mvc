package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.bdi.dao.BoardDAO;
import com.board.bdi.vo.BoardInfoVO;

public class BoardDAOImpl implements BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public int insertBoard(BoardInfoVO bi) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardInfoVO selectBoard(BoardInfoVO bi) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardInfoVO> selectBoardList(BoardInfoVO bi) throws SQLException {
		String sql = "select * from board_info";
		List<BoardInfoVO> biList = new ArrayList<BoardInfoVO>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				bi = new BoardInfoVO();
				bi.setBinum(rs.getInt("binum"));
				bi.setBititle(rs.getString("bititle"));
				bi.setBitext(rs.getString("bitext"));
				bi.setBifile(rs.getString("bifile"));
				bi.setBicredat(rs.getString("bicredat"));
				bi.setBimoddat(rs.getString("bimoddat"));
				bi.setBicnt(rs.getInt("bicnt"));
				biList.add(bi);
			}
			return biList;
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}
	private void close() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
