package com.date.jum5.user.pay.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.date.jum5.user.pay.vo.PayStateVo;
import com.date.jum5.user.pay.vo.PayVo;

@Repository
public class PayDao {

	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public PayDao(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//결제 횟수
	public int price(String buyer) {
		return sqlSession.selectOne("price", buyer);
	}
	
	//결제
	public void priceUpdate(PayVo payVo) {
		sqlSession.update("priceUpdate", payVo);
	}

		
	//등급별 데이트 횟수 +
	public void rankUpdate(PayVo payVo) {
		sqlSession.update("rankUpdate", payVo);
	}
	
	//유저 멤버십 등급 가져오기
	public int userMembership(String buyer) {
		return sqlSession.selectOne("userMembership", buyer);
	}
	
	//첫 결제
	public int firstPayment(String buyer) {
		return sqlSession.selectOne("firstPayment", buyer);
	}

	public void updateFirstPayment(PayVo payVo) {
		sqlSession.update("fMembershipUpdate", payVo);
	}
	
	public void updateFirst(String buyer) {
		sqlSession.update("updateFirst", buyer);
	}
	
	//추가 데이트 횟수 증가
	public void dateCountUpdate(PayVo payVo) {
		sqlSession.update("dateCountUpdate", payVo);
	}
	
	//결제 현황 삽입
	public void insertPayState(PayStateVo payStateVo) {
		sqlSession.insert("insertPayState", payStateVo);
	}
	
}
