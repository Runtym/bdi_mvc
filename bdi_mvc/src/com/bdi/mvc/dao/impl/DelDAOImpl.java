package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.DelDAO;

public class DelDAOImpl implements DelDAO {

	@Override
	public List<Map<String, String>> selectDelList() throws SQLException {
		try {
			Connection con = DBCon.getCon();
			String sql = "select * from del";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Map<String, String>> list = 
					new ArrayList<Map<String,String>>();
			while(rs.next()) {
				Map<String,String> hm = new HashMap<String,String>();
				hm.put("num",rs.getString("num"));
				hm.put("name",rs.getString("name"));
				hm.put("age",rs.getString("age"));
				list.add(hm);
			}
			return list;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, String> selectDel(int num) throws SQLException {
		try {
			Connection con = DBCon.getCon();
			String sql = "select * from del where num=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Map<String,String> hm = new HashMap<String,String>();
				hm.put("num",rs.getString("num"));
				hm.put("name",rs.getString("name"));
				hm.put("age",rs.getString("age"));
				return hm;
			}
			return null;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public int deleteDels(String[] nums) throws SQLException {
		int cnt = 0;
		try {
			Connection con = DBCon.getCon();
			String sql = "delete from del where num=?";
			PreparedStatement ps = con.prepareStatement(sql);
			for(String num:nums) {
				ps.setString(1, num);
				cnt += ps.executeUpdate();
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
		return cnt;
	}

	@Override
	public int insertDel(String name, String age) throws SQLException {
		try {
			Connection con = DBCon.getCon();
			String sql = "insert into del(name, age)";
			sql += "values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, age);
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}
