package com.bdi.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bdi.mvc.vo.Depart;

public interface DepartDAO {
	
	public void setConnection(Connection con);
	public List<Depart> selectDepartList(Depart depart)throws SQLException;
	public Depart selectDepart(Depart depart)throws SQLException;
	public int insertDepart(Depart depart)throws SQLException;
	public int updateDepart(Depart depart)throws SQLException;
	public int deleteDepart(Depart depart)throws SQLException;
}
