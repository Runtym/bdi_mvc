package com.bdi.mvc.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.vo.Game;

public interface GameService {
	public List<Game> selectGameList(Game game)throws SQLException;
	public Game selectGame(Game game)throws SQLException;
	public Map<String,Object> insertGame(Game game)throws SQLException;
	public Map<String,Object> updateGame(Game game)throws SQLException;
	public Map<String,Object> deleteGame(Game game)throws SQLException;
}
