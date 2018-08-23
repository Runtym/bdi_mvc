package com.bdi.mvc.dao;

import java.util.List;
import java.util.Map;

import com.bdi.mvc.vo.Maker;

public interface MakerDAO {
	public List<Maker> selectMakerList(Maker mk);
	public Maker selectMaker(int mNum);
	public Map<String,Object> insertMaker(Maker mk);
	public Map<String,Object> updateMaker(Maker mk);
	public Map<String,Object> deleteMaker(Maker mk);
}
