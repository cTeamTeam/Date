package com.date.jum5.manager.question.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.date.jum5.manager.question.dao.ManagerQuestionDao;
import com.date.jum5.manager.question.vo.AdminQuestionVo;

@Service
public class ManagerQuestionMapper {
	
	private ManagerQuestionDao managerQuestionDao;
	
	@Autowired
	public ManagerQuestionMapper(ManagerQuestionDao managerQuestionDao) {
		this.managerQuestionDao=managerQuestionDao;
	}
	
	//답변 집어넣dma
	public void insertAnswer(AdminQuestionVo adminQuestionVo) {
		
		System.out.println("hello");
		managerQuestionDao.insertAnswer(adminQuestionVo);
	}
	
	//답변 상태 업데이트
	public void updateState(int num) {
		managerQuestionDao.updateState(num);
	}
	
	//답변 가져오기
	public AdminQuestionVo answer(int qaNum) {
		return managerQuestionDao.answer(qaNum);
	}
	
	//답변 삭제
	public void answerDelete(int qaNum) {
		managerQuestionDao.answerDelete(qaNum);
	}
	
	//답변 삭제시 상태 변화
	public void deleteUpdateState(int qaNum) {
		managerQuestionDao.deleteUpdateState(qaNum);
	}
	
	//답변 수정
	public void modifyAnswer(AdminQuestionVo adminQuestionVo) {
		managerQuestionDao.modifyAnswer(adminQuestionVo);
	}
	
}
