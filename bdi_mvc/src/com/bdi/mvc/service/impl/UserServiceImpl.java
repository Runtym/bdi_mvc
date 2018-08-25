package com.bdi.mvc.service.impl;

import java.util.List;

import com.bdi.mvc.dao.UserDAO;
import com.bdi.mvc.dao.impl.UserDAOImpl;
import com.bdi.mvc.service.UserService;
import com.bdi.mvc.vo.User;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
	@Override
	public List<User> getUserList(User ui) {
		// TODO Auto-generated method stub
		return udao.selectUserList(ui);
	}

	@Override
	public User getUser(int uiNum) {
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
