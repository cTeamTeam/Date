package com.date.jum5.user.mypage.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.jum5.user.login.vo.LoginVo;
import com.date.jum5.user.mypage.dao.MyPageDao;
import com.date.jum5.user.mypage.vo.ProfileVo;

@Service
public class MyPageMapper {
	
	@Autowired
	MyPageDao dao;
	
	public MyPageDao getDao() {
		return dao;
	}

	public void setDao(MyPageDao dao) {
		this.dao = dao;
	}

	//마이페이지 테스트
	public List<LoginVo> mypageList(String id){
		return dao.mypageList(id);
	}

	public void write(ProfileVo profileVo) {
		// TODO Auto-generated method stub
		dao.insert(profileVo);
	}
	
	public List<ProfileVo> profileList(String id){
		return dao.profileList(id);
	}

	public int edit(LoginVo loginVo) {
		return dao.update(loginVo);
	}

	public int delete(LoginVo loginVo) {
		// TODO Auto-generated method stub
		return dao.delete(loginVo);
	}

	public int editProfile(ProfileVo profileVo) {
		// TODO Auto-generated method stub
		return dao.updateProfile(profileVo);
	}

	
}
