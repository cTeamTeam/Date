package com.date.jum5.user.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.member.vo.MemberVo;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
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
	
	
	
}
