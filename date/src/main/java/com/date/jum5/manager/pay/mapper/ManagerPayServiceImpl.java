package com.date.jum5.manager.pay.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.jum5.manager.pay.dao.ManagerPayDao;
import com.date.jum5.user.pay.vo.PayStateVo;

@Service
public class ManagerPayServiceImpl implements ManagerPayService{

	@Autowired
	private ManagerPayDao managerPayDao;
	
	public ManagerPayDao getManagerPayDao() {
		return managerPayDao;
	}
	
	public void setManagerPayDao(ManagerPayDao managerPayDao) {
		this.managerPayDao = managerPayDao;
	}
	
	@Override
	public List<PayStateVo> payList(){
		return managerPayDao.payList();
	}
	
	@Override
	public List<PayStateVo> paySearchList(String searchOption, String keyword) throws Exception{
		return managerPayDao.paySearchList(searchOption, keyword);
	}
	
	@Override
	public int payCountArticle(String searchOption, String keyword) throws Exception{
		return managerPayDao.payCountArticle(searchOption, keyword);
	}
}
