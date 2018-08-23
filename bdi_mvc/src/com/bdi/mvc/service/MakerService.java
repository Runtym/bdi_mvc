package com.bdi.mvc.service;

import java.util.List;
import java.util.Map;

import com.bdi.mvc.vo.Maker;

public interface MakerService {
	public List<Maker> getMakerList(Maker mk);
	public Maker getMaker(int mNum);
	public Map<String,Object> insertMaker(Maker mk);
	public Map<String,Object> updateMaker(Maker mk);
	public Map<String,Object> deleteMaker(Maker mk);
}
