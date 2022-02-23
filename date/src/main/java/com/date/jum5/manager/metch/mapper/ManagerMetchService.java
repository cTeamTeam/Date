package com.date.jum5.manager.metch.mapper;

import java.util.List;

import com.date.jum5.user.metch.vo.MetchVo;

public interface ManagerMetchService {

	public abstract List<MetchVo> metchAllList();
	
	public abstract MetchVo read(int idx);
	
	public abstract int delete(MetchVo metchVo);
	
	public abstract List<MetchVo> metchList();
	
	public List<MetchVo> metchSearchList(String searchOption, String keyword) throws Exception;
	
	public int metchCountArticle(String searchOption, String keyword) throws Exception;
}
