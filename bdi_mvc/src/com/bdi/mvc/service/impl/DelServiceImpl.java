package com.bdi.mvc.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.dao.DelDAO;
import com.bdi.mvc.dao.impl.DelDAOImpl;
import com.bdi.mvc.service.DelService;

public class DelServiceImpl implements DelService {
	private DelDAO ddao = new DelDAOImpl();
	@Override
	public List<Map<String, String>> getDelList() throws SQLException {
		return ddao.selectDelList();
	}
	@Override
	public Map<String, String> getDel(int num) throws SQLException {
		return ddao.selectDel(num);
	}
	@Override
	public List<Map<String, String>> deleteDels(String[] nums) throws SQLException {
		int cnt = ddao.deleteDels(nums);
		return ddao.selectDelList();
	}
	@Override
	public int insertDel(String name, String age) throws SQLException {
		return ddao.insertDel(name, age);
	}
	@Override
	public int updateDel(int num, String name, String age) throws SQLException {
		return ddao.updateDel(num, name, age);
	}

}
