package com.bdi.mvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.dao.GameDAO;
import com.bdi.mvc.vo.Game;

public class GameDAOImpl implements GameDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<Game> selectGameList(Game game) throws SQLException {
		String sql = "select * from game_chart";
		List<Game> gameList = new ArrayList<Game>();
		try {
			//여기서 connection을 맺는 코드가 없는 이유는 서비스에서 
			//GameDAOImpl의 setConnection(DBCon.getCon())을 호출해
			//여기서 사용할 connection을 셋팅해주기 때문이다.
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Game g = new Game(rs.getInt("gcNum"),
							rs.getString("gcName"),
							rs.getInt("gcPrice"),
							rs.getString("gcVendor"),
							rs.getInt("gcOrder"),
							rs.getString("gcDesc"),
							rs.getString("gcImg")
						);
				gameList.add(g);
			}
			return gameList;
		}catch(SQLException e) {
			throw e;
		}finally {
			ps.close();
			rs.close();
		}
	}

	@Override
	public Game selectGame(Game game) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> insertGame(Game game) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateGame(Game game) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteGame(Game game) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

}
