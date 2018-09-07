package com.board.bdi.service.impl;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.board.bdi.common.DBCon;
import com.board.bdi.common.ParseUtil;
import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.service.UserService;
import com.board.bdi.vo.UserInfoVO;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();

	@Override
	public void joinUser(HttpServletRequest req) throws SQLException, ServletException {
		UserInfoVO ui = ParseUtil.parseRequest(req, UserInfoVO.class);
		udao.setCon(DBCon.getCon());
		try {
			if (udao.selectUser(ui) == null) {
				int cnt = udao.insertUser(ui);
				req.setAttribute("cnt", cnt);
				DBCon.commit();
			} else {
				req.setAttribute("err", "아이디 중복 됬다고!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
	}

	@Override
	public void loginUser(HttpServletRequest req) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void logoutUser(HttpServletRequest req) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(HttpServletRequest req) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void userList(HttpServletRequest req) throws SQLException {
		// TODO Auto-generated method stub

	}

}
