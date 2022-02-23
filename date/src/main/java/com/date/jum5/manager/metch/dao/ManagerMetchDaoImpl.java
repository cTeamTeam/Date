package com.date.jum5.manager.metch.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.metch.vo.MetchVo;

@Repository
public class ManagerMetchDaoImpl implements ManagerMetchDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public ManagerMetchDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<MetchVo> metchAllList(){
		return sqlSessionTemplate.selectList("metchAllList");
	}
	
	@Override
	public MetchVo select(int idx) {
		MetchVo metchVo = (MetchVo)sqlSessionTemplate.selectOne("metchSelect", idx);
		return metchVo;
	}
	
	@Override
	public int metchDelete(MetchVo metchVo) {
		return sqlSessionTemplate.delete("metchDelete", metchVo);
	}
	
	@Override
	public List<MetchVo> metchList(){
		return sqlSessionTemplate.selectList("metchList");
	}
	
	@Override
	public List<MetchVo> metchSearchList(String searchOption, String keyword) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectList("metchSearchList", map);
	}
	
	@Override
	public int metchCountArticle(String searchOption, String keyword) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectOne("metchCountArticle", map);
	}
}
