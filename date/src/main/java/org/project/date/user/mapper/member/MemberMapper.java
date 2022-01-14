package org.project.date.user.mapper.member;

import org.project.date.user.dao.member.MemberDao;
import org.project.date.user.vo.member.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberMapper {
	
	@Autowired
	private MemberDao memberdao;
	
	public MemberMapper(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
	//회원가입
	public void test(MemberVo member) {
		memberdao.test(member);
	}
	
	//아이디 중복 체크
	public int idCheck(String id) {
		return memberdao.idCheck(id);
	}
	
	public int nickNameCheck(String nickName) {
		return memberdao.nickNameCheck(nickName);
	}
}
