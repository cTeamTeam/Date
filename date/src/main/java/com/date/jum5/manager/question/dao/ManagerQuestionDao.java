package com.date.jum5.manager.question.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.manager.question.vo.AdminQuestionVo;

@Repository
public class ManagerQuestionDao {
	
	private SqlSessionTemplate sqlsession;
	
	@Autowired
	public ManagerQuestionDao(SqlSessionTemplate sqlsession) {
		this.sqlsession=sqlsession;
	}
	
	//답변 집어 넣음
	public void insertAnswer(AdminQuestionVo adminQuestionVo) {
		System.out.println(adminQuestionVo.getAnswer());
		System.out.println(adminQuestionVo.getQaNum());
		sqlsession.insert("insertAnswer", adminQuestionVo);
	}
	
	//답변 상태 업데이트
	public void updateState(int num) {
		sqlsession.update("updateState", num);
	}
	
	//답변 가져오기
	public AdminQuestionVo answer(int qaNum) {
		return sqlsession.selectOne("answer", qaNum);
	}
	
	//답변 삭제
	public void answerDelete(int qaNum) {
		sqlsession.delete("answerDelete", qaNum);
	}
	
	//답변 삭제시 상태 변화
	public void deleteUpdateState(int qaNum) {
		sqlsession.update("deleteUpdateState", qaNum);
	}
	
	//답변 수정
	public void modifyAnswer(AdminQuestionVo adminQuestionVo) {
		sqlsession.update("modifyAnswer", adminQuestionVo);
	}
}
