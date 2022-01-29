package com.date.jum5.user.mypage.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.jum5.user.login.vo.LoginVo;
import com.date.jum5.user.mypage.dao.MyPageDao;

@Service
public class MyPageMapper {
	
	@Autowired
	MyPageDao dao;
	
	//마이페이지 테스트
	public List<LoginVo> list(String id){
		return dao.list(id);
	}

	
}
