package com.bdi.mvc.dao;

import java.util.List;
import java.util.Map;

import com.bdi.mvc.vo.Maker;

public interface MakerDAO {
	public List<Maker> selectMakerList(Maker mk);
	public Maker selectMaker(int mNum);
	public int insertMaker(Maker mk);
	public Map<String,Object> updateMaker(Maker mk);
	public Map<String,Object> deleteMaker(Maker mk);
	public int updateMakerTotal(int mNum);
}
