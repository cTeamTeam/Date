package com.date.jum5.user.login.mapper;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.date.jum5.user.login.dao.LoginDao;
import com.date.jum5.user.login.vo.LoginVo;

@Repository
public class LoginServiceImpl implements LoginService{
	
	@Inject
	private LoginDao loginDao;
	
	@Override
	public LoginVo checkId(String pw) throws Exception {
		
		return loginDao.checkId(pw);
	}
	
	@Override
	public LoginVo forGot(LoginVo loginVo) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.forGot(loginVo);	
	}
	
	@Override
	public LoginVo forGotPw(LoginVo loginVo) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.forGotPw(loginVo);
	}
	
	@Override
	public String pwTranslator(String id) {
		// TODO Auto-generated method stub
		return loginDao.pwTranslator(id);
	}
}
