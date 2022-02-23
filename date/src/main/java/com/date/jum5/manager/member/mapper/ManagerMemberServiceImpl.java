package com.date.jum5.manager.member.mapper;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.date.jum5.manager.member.dao.ManagerMemberDao;
import com.date.jum5.user.member.vo.MemberVo;

@Service
public class ManagerMemberServiceImpl implements ManagerMemberService{

	@Inject
	ManagerMemberDao managermemberdao;
	
	@Override
	public List<MemberVo> memberList(){
		return managermemberdao.memberList();
	}
}
