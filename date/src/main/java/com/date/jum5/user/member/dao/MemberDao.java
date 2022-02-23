package com.date.jum5.user.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.member.vo.MemberVo;

@Repository
public class MemberDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public MemberDao(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate=sqlSessionTemplate;
	}
	
	public void registMember(MemberVo member) {
		sqlSessionTemplate.insert("insert", member);
	}
	
	public int idCheck(String id) {
		return sqlSessionTemplate.selectOne("idCheck", id);
	}
	
	public int nickNameCheck(String nickName) {
		return sqlSessionTemplate.selectOne("nickNameCheck", nickName);
	}
	
	public int emailCheck(String email) {
		return sqlSessionTemplate.selectOne("emailCheck", email);
	}
	
	//마이페이지
	public List<MemberVo> myPage(String id){
		return sqlSessionTemplate.selectList("myPage",id);
	}
		
	//마이페이지 테스트
	public List<MemberVo> list(){
		return sqlSessionTemplate.selectList("list");
	}
		
	//회원 탈퇴 테스트
	public int withdraw() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("withdraw");
	}
	
	//카카오로 로그인했을떄 해당 유저 정보 존재하는지 확인
	public int kakaoMemberCheck(String id) {
		return sqlSessionTemplate.selectOne("kakaoMemberExist", id);
	}

}
