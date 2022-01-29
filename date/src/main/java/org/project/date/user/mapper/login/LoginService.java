package org.project.date.user.mapper.login;

import org.project.date.user.vo.login.LoginVo;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	
	public LoginVo checkId(String pw) throws Exception;
	
	public LoginVo forGot(LoginVo forGot) throws Exception;
	
	public LoginVo forGotPw(LoginVo forGotPw) throws Exception;
	
	public String pwTranslator(String id);
}
