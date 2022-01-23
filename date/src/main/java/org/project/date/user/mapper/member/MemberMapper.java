package org.project.date.user.mapper.member;

import java.util.List;

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
	
	
	//마이 페이지
	public List<MemberVo> myPage(String id) {
		return memberdao.myPage(id);
	}
	
	//마이페이지 테스트
	public List<MemberVo> list(){
		return memberdao.list();
	}

	public int withdraw() {
		// TODO Auto-generated method stub
		return memberdao.withdraw();
	}
}
