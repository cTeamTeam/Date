package org.project.date.user.mapper.login;

import javax.inject.Inject;

import org.project.date.user.dao.login.LoginDao;
import org.project.date.user.vo.login.LoginVo;
import org.springframework.stereotype.Repository;

@Repository
public class LoginServiceImpl implements LoginService{
	
	@Inject
	private LoginDao loginDao;

	//�α���
	@Override
	public LoginVo checkId(LoginVo loginVo) throws Exception {
		return loginDao.checkId(loginVo);
	}
	
	//���̵� ã��
	@Override
	public LoginVo forGot(LoginVo loginVo) throws Exception{
		return loginDao.forGot(loginVo);
	}
	
	//��й�ȣ ã��
	@Override
	public LoginVo forGotPw(LoginVo loginVo) throws Exception{
		return loginDao.forGotPw(loginVo);
	}

	@Override
	public String pwTranslator(String id) {
		// TODO Auto-generated method stub
		return loginDao.pwTranslator(id);
	}
}