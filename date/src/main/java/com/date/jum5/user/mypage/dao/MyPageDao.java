package com.date.jum5.user.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.login.vo.LoginVo;
import com.date.jum5.user.mypage.vo.ProfileVo;

@Repository
public class MyPageDao {
	
	@Autowired
	SqlSession sqlSessionTemplate;
	
		
		//마이페이지 테스트
		public List<LoginVo> mypageList(String id){
			return sqlSessionTemplate.selectList("mypageList", id);
			
		}
		
		//회원 탈퇴 테스트
		public int withdraw() {
			// TODO Auto-generated method stub
			return sqlSessionTemplate.update("withdraw");
		}

		public void insert(ProfileVo profileVo) {
			// TODO Auto-generated method stub
			sqlSessionTemplate.insert("insertProfile",profileVo);
		}

		public List<ProfileVo> profileList(String id) {
			// TODO Auto-generated method stub
			return sqlSessionTemplate.selectList("profileList",id);
		}

		public int update(LoginVo loginVo) {
			return sqlSessionTemplate.update("update",loginVo);
		}

		public int delete(LoginVo loginVo) {
			// TODO Auto-generated method stub
			return sqlSessionTemplate.delete("delete",loginVo);
		}

		public int updateProfile(ProfileVo profileVo) {
			// TODO Auto-generated method stub
			return sqlSessionTemplate.update("updateProfile",profileVo);
		}

		
	
}
