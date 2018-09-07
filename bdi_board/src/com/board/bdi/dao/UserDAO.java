package com.board.bdi.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.board.bdi.vo.UserInfoVO;

public interface UserDAO {
	public void setCon(Connection con);
	public int insertUser(UserInfoVO ui) throws SQLException;
	public UserInfoVO selectUser(UserInfoVO ui)throws SQLException;
}
