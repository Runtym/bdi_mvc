package com.bdi.mvc.service;

import java.util.List;

import com.bdi.mvc.vo.User;

public interface UserService {

	public List<User> getUserList(User ui);
	public User getUser(int uiNum);
	public int insertUser(User ui);
	public int updateUser(User ui);
	public int deleteUser(int uiNum);
}
