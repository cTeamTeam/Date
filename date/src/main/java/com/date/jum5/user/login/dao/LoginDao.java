package com.date.jum5.user.login.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.login.vo.LoginVo;


@Repository
public class LoginDao {

	@Autowired
	SqlSession sqlsession = null;

	//���̵� �˻�
	public LoginVo checkId(String pw) throws Exception{
		return (LoginVo)sqlsession.selectOne("login.checkId", pw); // login.checkid = mapper login.xml	
	}
	
	
	public String forGot(String inputEmail) throws Exception{
		return sqlsession.selectOne("login.forGot", inputEmail);
	}
	
	public LoginVo forGotPw(LoginVo pwSerchOk) throws Exception{
		return (LoginVo)sqlsession.selectOne("login.forGotPw", pwSerchOk);
	}
	
	public String pwTranslator(String id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("pwTranslate", id);
	}
	
	public int idExist(String id) {
		return sqlsession.selectOne("idExist", id);
	}
	
	public void changePw(Map<String, String> change) {
		sqlsession.update("changePw", change);
	}
	
	public String pwTranslatorDelete(String nickname) {
		return sqlsession.selectOne("pwTranslateDelete", nickname);
	}
	
	public LoginVo editMember(String nickname) {
		return sqlsession.selectOne("editMember", nickname);
	}


}
