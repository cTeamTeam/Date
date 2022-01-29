package org.project.date.user.mapper.login;

import javax.inject.Inject;
import org.project.date.user.dao.login.LoginDao;
import org.project.date.user.vo.login.LoginVo;
import org.springframework.stereotype.Repository;

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
