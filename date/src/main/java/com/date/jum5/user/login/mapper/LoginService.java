package com.date.jum5.user.login.mapper;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.date.jum5.user.login.vo.LoginVo;

@Service
public interface LoginService {
	//�α���
	public LoginVo checkId(String pw) throws Exception;
	
	//���̵� ã��
	public LoginVo forGot(LoginVo forGot) throws Exception;
	
	//��й�ȣ ã��
	public LoginVo forGotPw(LoginVo forGotPw) throws Exception;

	public String pwTranslator(String id);
	
	//비밀번호 찾기 아이디 존재여부
	public int idExist(String id);
	
	//비밀번호 변경
	public void changePw(Map<String, String> chagne);
	
}
