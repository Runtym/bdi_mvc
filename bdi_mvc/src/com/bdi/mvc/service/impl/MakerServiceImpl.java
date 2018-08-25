package com.bdi.mvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.dao.MakerDAO;
import com.bdi.mvc.dao.impl.MakerDAOImpl;
import com.bdi.mvc.service.MakerService;
import com.bdi.mvc.vo.Maker;

public class MakerServiceImpl implements MakerService {
	private MakerDAO mdao = new MakerDAOImpl();
	@Override
	public List<Maker> getMakerList(Maker mk) {
		return mdao.selectMakerList(mk);
	}

	@Override
	public Maker getMaker(int mNum) {
		// TODO Auto-generated method stub
		return mdao.selectMaker(mNum);
	}

	@Override
	public Map<String, Object> insertMaker(Maker mk) {
		Map<String, Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "메이커 등록 오류!");
		rMap.put("success", "false");
		if(mdao.insertMaker(mk)==2) {
			rMap.put("msg", "정상적으로 등록 되었습니다.");
			rMap.put("success", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, Object> updateMaker(Maker mk) {
		Map<String, Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "수정 실패");
		rMap.put("success", "false");
		int cnt = mdao.updateMaker(mk);
		if(cnt==1) {
			if(mdao.updateMakerTotal(mk.getMnum())==1) {
				rMap.put("msg", "수정 성공");
				rMap.put("success", "true");
			}
		}
		return rMap;
	}

	@Override
	public Map<String, Object> deleteMaker(Maker mk) {
		Map<String, Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "삭제 실패");
		rMap.put("success", "false");
		int cnt = mdao.deleteMaker(mk);
		if(cnt==1) {
			rMap.put("msg", "삭제 성공");
			rMap.put("success", "true");
		}
		return rMap;
	}

}
