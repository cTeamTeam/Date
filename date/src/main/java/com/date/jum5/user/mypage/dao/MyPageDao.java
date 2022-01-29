package com.date.jum5.user.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.login.vo.LoginVo;

@Repository
public class MyPageDao {
	
	@Autowired
	SqlSession sqlSessionTemplate;
	
	LoginVo vo = new LoginVo();
		
		//마이페이지 테스트
		public List<LoginVo> list(String id){
			System.out.println(vo.getId());
			return sqlSessionTemplate.selectList("list", id);
			
		}
		
		//회원 탈퇴 테스트
		public int withdraw() {
			// TODO Auto-generated method stub
			return sqlSessionTemplate.update("withdraw");
		}

		
	
}
