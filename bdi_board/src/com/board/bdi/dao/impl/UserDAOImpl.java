package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.bdi.dao.UserDAO;
import com.board.bdi.vo.UserInfoVO;

public class UserDAOImpl implements UserDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int insertUser(UserInfoVO ui) throws SQLException {
		String sql = "insert into user_info(uiid, uiname, uipwd, uiemail)";
		sql += " values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUiid());
			ps.setString(2, ui.getUiname());
			ps.setString(3, ui.getUipwd());
			ps.setString(4, ui.getUiemail());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public UserInfoVO selectUser(UserInfoVO ui) throws SQLException {
		String sql = "select * from user_info ";
		sql += " where uiid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUiid());
			rs = ps.executeQuery();
			if(rs.next()) {
				ui = new UserInfoVO();
				ui.setUiid(rs.getString("uiid"));
				ui.setUinum(rs.getInt("uinum"));
				ui.setUiemail(rs.getString("uiemail"));
				ui.setUiname(rs.getString("uiname"));
				ui.setUipwd(rs.getString("uipwd"));
				return ui;
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		return null;
	}
	
	private void close() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
