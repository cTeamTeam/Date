package org.project.date.user.mapper.mypage;

import java.util.List;

import org.project.date.user.dao.mypage.MyPageDao;
import org.project.date.user.vo.login.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageMapper {
	
	@Autowired
	MyPageDao dao;
	
	//마이페이지 테스트
	public List<LoginVo> list(){
		return dao.list();
	}

	
}
