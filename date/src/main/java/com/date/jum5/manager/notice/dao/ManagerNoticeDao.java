package com.date.jum5.manager.notice.dao;

import java.util.List;

import com.date.jum5.manager.notice.vo.ManagerNoticeVo;

public interface ManagerNoticeDao {
	
	public abstract List<ManagerNoticeVo> noticeList();
	
	public abstract void noticeInsert(ManagerNoticeVo managerNoticeVo);
	
	public abstract ManagerNoticeVo noticeSelect(int num);

	public abstract int noticeUpdate(ManagerNoticeVo managerNoticeVo);

	public abstract int updateReadCount(int num);

	public abstract int noticeDelete(ManagerNoticeVo managerNoticevo);
	
	public List<ManagerNoticeVo> searchList(String searchOption, String keyword) throws Exception;
	
	public int countArticle(String searchOption, String kewyword) throws Exception;
}
