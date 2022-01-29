package com.date.jum5.user.member.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.jum5.user.member.dao.MemberDao;
import com.date.jum5.user.member.vo.MemberVo;

@Service
public class MemberMapper {
	
	@Autowired
	private MemberDao memberdao;
	
	public MemberMapper(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
	//회원가입
	public void registMember(MemberVo member) {
		memberdao.registMember(member);
	}
	
	//아이디 중복 체크
	public int idCheck(String id) {
		return memberdao.idCheck(id);
	}
	
	public int nickNameCheck(String nickName) {
		return memberdao.nickNameCheck(nickName);
	}
	
	public int emailCheck(String email) {
		return memberdao.emailCheck(email);
	}
	
	
	

	
}
