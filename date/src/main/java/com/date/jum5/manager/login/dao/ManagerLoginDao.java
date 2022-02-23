package com.date.jum5.manager.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.manager.login.vo.ManagerLoginVo;

@Repository
public class ManagerLoginDao {

	@Autowired
	SqlSession sqlsession;
	
	public String checkId(String id) throws Exception{
		return sqlsession.selectOne("adminLogin", id); 	
	}

	public int idExist(String id) {
		return sqlsession.selectOne("adminIdExist", id);
	}
}
