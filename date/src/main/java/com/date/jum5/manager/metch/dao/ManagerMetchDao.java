package com.date.jum5.manager.metch.dao;

import java.util.List;

import com.date.jum5.user.metch.vo.MetchVo;

public interface ManagerMetchDao {

	public abstract List<MetchVo> metchAllList();
	
	public abstract MetchVo select(int idx);
	
	public abstract int metchDelete(MetchVo metchVo);
	
	public abstract List<MetchVo> metchList();
	
	public List<MetchVo> metchSearchList(String searchOption, String keyword) throws Exception;
	
	public int metchCountArticle(String searchOption, String kewyword) throws Exception;
}
