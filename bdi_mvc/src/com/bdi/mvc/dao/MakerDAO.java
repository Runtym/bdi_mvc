package com.bdi.mvc.dao;

import java.util.List;

import com.bdi.mvc.vo.Maker;

public interface MakerDAO {
	public List<Maker> selectMakerList(Maker mk);
	public Maker selectMaker(int mNum);
	public int insertMaker(Maker mk);
	public int updateMaker(Maker mk);
	public int deleteMaker(Maker mk);
	public int updateMakerTotal(int mNum);
}
