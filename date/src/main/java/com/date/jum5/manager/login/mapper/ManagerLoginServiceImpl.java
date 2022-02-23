package com.date.jum5.manager.login.mapper;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.date.jum5.manager.login.dao.ManagerLoginDao;
import com.date.jum5.manager.login.vo.ManagerLoginVo;

@Repository
public class ManagerLoginServiceImpl implements ManagerLoginService{

	@Inject
	private ManagerLoginDao loginDao;
	
	@Override
	public String checkId(String id) throws Exception {
		return loginDao.checkId(id);
	}

	@Override
	public int idExist(String id) {
		return loginDao.idExist(id);
	}
}
