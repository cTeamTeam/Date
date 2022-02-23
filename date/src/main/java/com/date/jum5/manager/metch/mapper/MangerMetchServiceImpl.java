package com.date.jum5.manager.metch.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.jum5.manager.metch.dao.ManagerMetchDao;
import com.date.jum5.user.metch.vo.MetchVo;

@Service
public class MangerMetchServiceImpl implements ManagerMetchService{

	@Autowired
	private ManagerMetchDao managerMetchDao;
	
	public ManagerMetchDao getManagerMetchDao() {
		return managerMetchDao;
	}
	
	public void setManagerMetchDao(ManagerMetchDao managerMetchDao) {
		this.managerMetchDao = managerMetchDao;
	}
	
	@Override
	public List<MetchVo> metchAllList(){
		return managerMetchDao.metchAllList();
	}
	
	@Override
	public MetchVo read(int idx) {
		return managerMetchDao.select(idx);
	}
	
	@Override
	public int delete(MetchVo metchVo) {
		return managerMetchDao.metchDelete(metchVo);
	}
	
	@Override
	public List<MetchVo> metchList(){
		return managerMetchDao.metchList();
	}
	
	@Override
	public List<MetchVo> metchSearchList(String searchOption, String keyword) throws Exception{
		return managerMetchDao.metchSearchList(searchOption, keyword);
	}
	
	@Override
	public int metchCountArticle(String searchOption, String keyword) throws Exception{
		return managerMetchDao.metchCountArticle(searchOption, keyword);
	}
}
