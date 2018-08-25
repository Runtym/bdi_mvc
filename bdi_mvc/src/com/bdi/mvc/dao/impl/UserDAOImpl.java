package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.UserDAO;
import com.bdi.mvc.vo.Maker;
import com.bdi.mvc.vo.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> selectUserList(User ui) {
		List<User> list = new ArrayList<User>();
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select uiNo, uiName, uiId, uiPwd, uiDesc, uiAge, diNo from user_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ui = new User(rs.getLong("uiNo"),
						rs.getString("uiName"),
						rs.getString("uiId"),
						rs.getString("uiPwd"),
						rs.getString("uiDesc"),
						rs.getInt("uiAge"),
						rs.getLong("diNo")
						);
				list.add(ui);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			}catch(SQLException e) {
				
			}
			DBCon.close();
		}
		return list;
	}

	@Override
	public User selectUser(int uiNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(User ui) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User ui) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int uiNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
