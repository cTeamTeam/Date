package com.date.jum5.user.question.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.jum5.user.question.dao.QuestionDao;
import com.date.jum5.user.question.vo.QuestionVo;

@Service
public class QuestionMapper {
	
	private QuestionDao questionDao;
	
	@Autowired
	public QuestionMapper(QuestionDao questionDao) {
		this.questionDao=questionDao;
	}
	
	//Q&A 작성
	public void questionWrite(QuestionVo question) {
		questionDao.questionWrite(question);
	}
	
	//Q&A 전체 리스트 가져오기
	public List<QuestionVo> questionAll(Map<String, Integer> pageRowMap) {
		return questionDao.questionAll(pageRowMap);
	}
	
	//저장된 총 글 수
	public int questionCount() {
		return questionDao.questionCount();
	}
	
	//상세 Q&A 출력
	public QuestionVo qaContent(int qaNum) {
		return questionDao.qaContent(qaNum);
	}
	
	//조회수 증가
	public void qaCount(int qaNum) {
		questionDao.qaCount(qaNum);
	}
	
	//자기 Q&A삭제
	public void qaDelete(int qaNum) {
		questionDao.qaDelete(qaNum);
	}
	
	//자기 Q&A 수정
	public void qaModify(QuestionVo question) {
		questionDao.qaModify(question);
	}
	
	//Q&A 제목으로 검색
	public List<QuestionVo> titleSearch(Map<String, Object> searchMap) {
		return questionDao.titleSearch(searchMap);
	}
	
	//Q&A 내용으로 검색
	public List<QuestionVo> contentSearch(Map<String, Object> searchMap) {
		return questionDao.contentSearch(searchMap);
	}
	
	//Q&A 작성자로 검색
	public List<QuestionVo> writerSearch(Map<String, Object> searchMap) {
		return questionDao.writerSearch(searchMap);
	}
	
	//검색한 글 갯수
	public int searchIdCount(String keyword) {
		return questionDao.searchIdCount(keyword);
	}
	
	//제목 검색 수
	public int searchTitleCount(String keyword) {
		return questionDao.searchTitleCount(keyword);
	}
		
	//내용 검색 수
	public int searchContentCount(String keyword) {
		return questionDao.searchContentCount(keyword);
	}
	

}
