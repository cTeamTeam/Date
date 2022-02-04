package com.date.jum5.user.question.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.question.vo.QuestionVo;

@Repository
public class QuestionDao {
	
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public QuestionDao(SqlSessionTemplate sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	//Q&A 작성
	public void questionWrite(QuestionVo question) {
		sqlSession.insert("qaWrite", question);
	}
	
	//전체 Q&A 가져오기
	public List<QuestionVo> questionAll(Map<String, Integer> pageRowMap) {
		return sqlSession.selectList("questionAll", pageRowMap);
	}
	
	//저장된 총 글 수
	public int questionCount() {
		return sqlSession.selectOne("questionCount");
	}
	
	//Q&A 상세글 추출
	public QuestionVo qaContent(int qaNum) {
		return (QuestionVo) sqlSession.selectOne("qaContent", qaNum);
	}
	
	//조회수 증가
	public void qaCount(int qaNum) {
		sqlSession.update("qaCount", qaNum);
	}
	
	//자기 Q&A 삭제
	public void qaDelete(int qaNum) {
		sqlSession.delete("qaDelete", qaNum);
	}
	
	//자기 Q&A 수정
	public void qaModify(QuestionVo question) {
		sqlSession.update("qaModify", question);
	}
	
	//Q&A 검색
	public List<QuestionVo> titleSearch(Map<String, Object> searchMap) {
		return sqlSession.selectList("titleSearch", searchMap);
	}
	
	//Q&A 내용으로 검색
	public List<QuestionVo> contentSearch(Map<String, Object> searchMap) {
		return sqlSession.selectList("contentSearch", searchMap);
	}
	
	//Q&A 작성자로 검색
	public List<QuestionVo> writerSearch(Map<String, Object> searchMap) {
		return sqlSession.selectList("writerSearch", searchMap);
	}
	
	//아이디 검색 수
	public int searchIdCount(String keyword) {
		return sqlSession.selectOne("searchIdCount", keyword);
	}
	
	//제목 검색 수
	public int searchTitleCount(String keyword) {
		return sqlSession.selectOne("searchTitleCount", keyword);
	}
	
	//내용 검색 수
	public int searchContentCount(String keyword) {
		return sqlSession.selectOne("searchContentCount", keyword);
	}

}
