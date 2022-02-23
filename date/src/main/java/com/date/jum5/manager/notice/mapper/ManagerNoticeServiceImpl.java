package com.date.jum5.manager.notice.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.jum5.manager.notice.dao.ManagerNoticeDao;
import com.date.jum5.manager.notice.vo.ManagerNoticeVo;

@Service
public class ManagerNoticeServiceImpl implements ManagerNoticeService{
	
	@Autowired
	private ManagerNoticeDao managerNoticeDao;

	
	public ManagerNoticeDao getManagerNoticeDao() {
		return managerNoticeDao;
	}

	public void setManagernoticedao(ManagerNoticeDao managerNoticeDao) {
		this.managerNoticeDao = managerNoticeDao;
	}
	
	@Override
	public List<ManagerNoticeVo> noticeList() {
		return managerNoticeDao.noticeList();
	}
	
	@Override
	public void write(ManagerNoticeVo managerNoticeVo) {
		managerNoticeDao.noticeInsert(managerNoticeVo);
	}
	
	@Override
	public ManagerNoticeVo read(int num) {
		managerNoticeDao.updateReadCount(num);
		return managerNoticeDao.noticeSelect(num);
	}
	
	@Override
	public int edit(ManagerNoticeVo managerNoticeVo) {
		return managerNoticeDao.noticeUpdate(managerNoticeVo);
	}

	@Override
	public int delete(ManagerNoticeVo managerNoticeVo) {
		return managerNoticeDao.noticeDelete(managerNoticeVo);
	}
	
	@Override
	public List<ManagerNoticeVo> searchList(String searchOption, String keyword) throws Exception{
		return managerNoticeDao.searchList(searchOption, keyword);
	}
	
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception{
		return managerNoticeDao.countArticle(searchOption, keyword);
	}
}
