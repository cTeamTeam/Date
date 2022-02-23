package com.date.jum5.manager.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.member.vo.MemberVo;

@Repository
public class ManagerMemberDao {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public ManagerMemberDao(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<MemberVo> memberList(){
		return sqlSessionTemplate.selectList("memberList");
	}
}
