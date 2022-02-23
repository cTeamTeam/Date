package com.date.jum5.user.metch.mapper;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.metch.dao.MetchDao;
import com.date.jum5.user.metch.vo.MetchVo;
import com.date.jum5.user.mypage.vo.ProfileVo;

@Repository
public class MetchMapper {

	@Autowired
	MetchDao dao;
	
	public List<ProfileVo> MetchList(String matchingGender) {
		// TODO Auto-generated method stub
		
		return dao.matchList(matchingGender);
	}

	public String GetGender(String userId) {
		// TODO Auto-generated method stub
		return dao.GetGender(userId);
	}



	public void requestDate(MetchVo metchVo) {
		dao.requestDate(metchVo);
		
	}
	
	
	//신청 현황 보기
	public List<MetchVo> RequestList(String userId) {
		return dao.getRequestList(userId);
	}
	
	
	

	public List<MetchVo> beRequested(String userId) {
		// TODO Auto-generated method stub
		return dao.getBeRequestedList(userId);
	}

	public void requestedAccept(int idx) {
		// TODO Auto-generated method stub
		dao.requestAccept(idx);
	}

	public void requestedDeny(int idx) {
		// TODO Auto-generated method stub
		dao.requestDeny(idx);
	}
	
	public List<ProfileVo> readProfile(String senderId) {
		// TODO Auto-generated method stub
		return dao.readProfile(senderId);
	}






	
}
