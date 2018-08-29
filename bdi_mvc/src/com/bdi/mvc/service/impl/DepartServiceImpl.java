package com.bdi.mvc.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.DepartDAO;
import com.bdi.mvc.dao.impl.DepartDAOImpl;
import com.bdi.mvc.service.DepartService;
import com.bdi.mvc.vo.Depart;

public class DepartServiceImpl implements DepartService {
	private DepartDAO ddao = new DepartDAOImpl();
	@Override
	public List<Depart> selectDepartList(Depart depart) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			return ddao.selectDepartList(null);
		} catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> insertDepart(Depart depart) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			int cnt = ddao.insertDepart(depart);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "저장이 실패했어요");
			if(cnt==1) {
				rMap.put("msg", "저장 성공했어요~~");
			}
			return rMap;
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Depart selectDepart(Depart depart) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			return ddao.selectDepart(depart);
		} catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}
