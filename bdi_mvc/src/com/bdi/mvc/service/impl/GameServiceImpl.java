package com.bdi.mvc.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.GameDAO;
import com.bdi.mvc.dao.impl.GameDAOImpl;
import com.bdi.mvc.service.GameService;
import com.bdi.mvc.vo.Game;

public class GameServiceImpl implements GameService{
	//서비스에서 사용할 GameDAOImpl을 생성한다.
	private GameDAO gdao = new GameDAOImpl();
	
	@Override
	public List<Game> selectGameList(Game game) throws SQLException {
		//GameDAOImpl에서 사용할 Connection을 여기서 셋해준다.
		gdao.setConnection(DBCon.getCon());
		try {
			return gdao.selectGameList(game);
		}catch(SQLException e) {
			throw e;
		}finally {
			//finally가 실행되는 시점은 성공하든 실패하던 무조건 완료된뒤 실행함으로
			//위에서 맺었던 db Connection을 여기서 끊어준다.
			DBCon.close();
		}
	}

	@Override
	public Game selectGame(Game game) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> insertGame(Game game) throws SQLException {
		//GameDAOImpl에서 사용할 Connection을 여기서 셋해준다.
		gdao.setConnection(DBCon.getCon());
		try {
			Map<String, Object> rMap = new HashMap<String,Object>();
			int cnt = gdao.insertGame(game);
			rMap.put("cnt", cnt);
			rMap.put("msg","게임등록이 실패");
			if(cnt==1) {
				rMap.put("msg","게임등록이 성공");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			//finally가 실행되는 시점은 성공하든 실패하던 무조건 완료된뒤 실행함으로
			//위에서 맺었던 db Connection을 여기서 끊어준다.
			DBCon.close();
		}
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

}
