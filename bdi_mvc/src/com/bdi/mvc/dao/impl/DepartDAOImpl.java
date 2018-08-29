package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.DepartDAO;
import com.bdi.mvc.vo.Depart;

public class DepartDAOImpl implements DepartDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<Depart> selectDepartList(Depart depart) throws SQLException {
		String sql = "select * from depart_info";
		List<Depart> departList = new ArrayList<Depart>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Depart dp = new Depart(rs.getInt("diNo"), rs.getString("diName"),
						rs.getString("diDesc"),rs.getInt("diCnt"));
				departList.add(dp);
			}
		}catch(SQLException e) {
			throw e;
		}
		return departList;
	}
	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}
	@Override
	public int insertDepart(Depart depart) throws SQLException {
		String sql = "insert into depart_info(diName, diDesc)";
		sql += " values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, depart.getDiName());
			ps.setString(2, depart.getDiDesc());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}
	@Override
	public Depart selectDepart(Depart depart) throws SQLException {		
		String sql = "select * from depart_info where diNo=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, depart.getDiNo());
			rs = ps.executeQuery();
			if(rs.next()) {
				return new Depart(rs.getInt("diNo"), rs.getString("diName"),
						rs.getString("diDesc"),rs.getInt("diCnt"));
			}
		}catch(SQLException e) {
			throw e;
		}
		return null;
	}
	@Override
	public int updateDepart(Depart depart) throws SQLException {
		String sql = "update depart_info set diName=?, diDesc=? ";
		sql += " where diNo=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, depart.getDiName());
			ps.setString(2, depart.getDiDesc());
			ps.setInt(3, depart.getDiNo());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}
	@Override
	public int deleteDepart(Depart depart) throws SQLException {
		String sql = "delete from depart_info where diNo=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, depart.getDiNo());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}

}
