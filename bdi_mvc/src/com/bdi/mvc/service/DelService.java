package com.bdi.mvc.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DelService {
	public List<Map<String,String>> getDelList() throws SQLException;
	public Map<String,String> getDel(int num) throws SQLException;
	public List<Map<String,String>> deleteDels(String[] nums)throws SQLException;
	public int insertDel(String name, String age)throws SQLException;
	public int updateDel(int num, String name, String age)throws SQLException;
}
