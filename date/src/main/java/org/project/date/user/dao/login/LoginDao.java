package org.project.date.user.dao.login;

import org.apache.ibatis.session.SqlSession;
import org.project.date.user.vo.login.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LoginDao {

	@Autowired
	SqlSession sqlsession = null;

	//���̵� �˻�
	public LoginVo checkId(String pw) throws Exception{
		return (LoginVo)sqlsession.selectOne("login.checkId", pw); // login.checkid = mapper login.xml	
	}
	
	//���̵� ã��
	
	public LoginVo forGot(LoginVo idSerchOk) throws Exception{
		return (LoginVo)sqlsession.selectOne("login.forGot", idSerchOk);
	}
	
	//��й�ȣ ã��
	public LoginVo forGotPw(LoginVo pwSerchOk) throws Exception{
		return (LoginVo)sqlsession.selectOne("login.forGotPw", pwSerchOk);
	}
	
	public String pwTranslator(String id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("pwTranslate", id);
	}
}