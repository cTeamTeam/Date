package com.date.jum5.manager.notice.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.manager.notice.vo.ManagerNoticeVo;

@Repository
public class ManagerNoticeDaoImpl implements ManagerNoticeDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public ManagerNoticeDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<ManagerNoticeVo> noticeList(){
		return sqlSessionTemplate.selectList("noticelist");
	}
	
	@Override
	public void noticeInsert(ManagerNoticeVo managerNoticeVo) {
		sqlSessionTemplate.insert("noticeinsert", managerNoticeVo); 
	}
	
	@Override
	public ManagerNoticeVo noticeSelect(int num) {
		ManagerNoticeVo managerNoticeVo = (ManagerNoticeVo)sqlSessionTemplate.selectOne("noticeselect", num);
		return managerNoticeVo;
	}
	
	@Override
	public int noticeUpdate(ManagerNoticeVo managerNoticeVo) {
		return sqlSessionTemplate.update("noticeupdate", managerNoticeVo);
	}
	
	@Override
	public int updateReadCount(int num) {
		return sqlSessionTemplate.update("countupdate", num);
	}
	
	@Override
	public int noticeDelete(ManagerNoticeVo managerNoticeVo) {
		return sqlSessionTemplate.delete("noticedelete", managerNoticeVo);
	}
	
	@Override
	public List<ManagerNoticeVo> searchList(String searchOption, String keyword) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectList("searchList", map);
	}
	
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSessionTemplate.selectOne("countArticle", map);
	}
}