package com.date.jum5.manager.pay.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.pay.vo.PayStateVo;

@Repository
public class ManagerPayDaoImpl implements ManagerPayDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public ManagerPayDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<PayStateVo> payList(){
		return sqlSessionTemplate.selectList("payList");
	}
	
	@Override
	public List<PayStateVo> paySearchList(String searchOption, String keyword){
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectList("paySearchList", map);
	}
	
	@Override
	public int payCountArticle(String searchOption, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectOne("payCountArticle", map);
	}
}
