package com.bdi.mvc.dao;

import java.util.List;

import com.bdi.mvc.vo.User;

public interface UserDAO {
	public List<User> selectUserList(User ui);
	public User selectUser(int uiNum);
	public int insertUser(User ui);
	public int updateUser(User ui);
	public int deleteUser(int uiNum);
}
