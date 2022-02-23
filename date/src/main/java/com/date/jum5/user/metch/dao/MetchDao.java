package com.date.jum5.user.metch.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.metch.vo.MetchVo;
import com.date.jum5.user.mypage.vo.ProfileVo;

@Repository
public class MetchDao {
	
	@Autowired
	SqlSession sqlSessionTemplate;

	public List<ProfileVo> matchList(String matchingGender) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("metchlist",matchingGender);
	}

	public String GetGender(String userId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("getGender", userId);
	}

	
	public void requestDate(MetchVo metchVo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("requestDate", metchVo);
	}
	
	//신청 현황 보기
	public List<MetchVo> getRequestList(String userId){
		return sqlSessionTemplate.selectList("requestList", userId);
	}

	public List<MetchVo> getBeRequestedList(String userId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("beRequestedList",userId);
	}

	public void requestAccept(int idx) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("requestAccept",idx);
	}

	public void requestDeny(int idx) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("requestDeny",idx);
	}
	
	public List<ProfileVo> readProfile(String senderId) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("readProfile",senderId);
	}



	
}
