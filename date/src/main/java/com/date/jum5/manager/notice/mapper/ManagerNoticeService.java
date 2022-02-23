package com.date.jum5.manager.notice.mapper;

import java.util.List;

import com.date.jum5.manager.notice.vo.ManagerNoticeVo;

public interface ManagerNoticeService {

	public abstract List<ManagerNoticeVo> noticeList();
	
	public abstract void write(ManagerNoticeVo managerNoticeVo);
	
	public abstract ManagerNoticeVo read(int num);
	
	public abstract int edit(ManagerNoticeVo managerNoticeVo);

	public abstract int delete(ManagerNoticeVo managerNoticeVo);

	public List<ManagerNoticeVo> searchList(String searchOption, String keyword) throws Exception;
	
	public int countArticle(String searchOption, String keyword) throws Exception;
}
