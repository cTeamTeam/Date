package org.project.date.user.mapper.login;

import org.project.date.user.vo.login.LoginVo;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	//�α���
	public LoginVo checkId(LoginVo id) throws Exception;
	
	//���̵� ã��
	public LoginVo forGot(LoginVo forGot) throws Exception;
	
	//��й�ȣ ã��
	public LoginVo forGotPw(LoginVo forGotPw) throws Exception;

	public String pwTranslator(String id);
}
