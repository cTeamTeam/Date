package com.date.jum5.user.login.mapper;

import org.springframework.stereotype.Service;

import com.date.jum5.user.login.vo.LoginVo;

@Service
public interface LoginService {
	
	public LoginVo checkId(String pw) throws Exception;
	
	public LoginVo forGot(LoginVo forGot) throws Exception;
	
	public LoginVo forGotPw(LoginVo forGotPw) throws Exception;
	
	public String pwTranslator(String id);
}
