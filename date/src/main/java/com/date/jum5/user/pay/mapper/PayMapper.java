package com.date.jum5.user.pay.mapper;

import org.springframework.stereotype.Service;

import com.date.jum5.user.pay.dao.PayDao;
import com.date.jum5.user.pay.vo.PayStateVo;
import com.date.jum5.user.pay.vo.PayVo;

@Service
public class PayMapper {
	
	private PayDao payDao;
	
	public PayMapper(PayDao payDao) {
		this.payDao = payDao;
	}
	
	//결제 횟수
	public int price(String buyer) {
		return payDao.price(buyer);
	}
	
	//결제 금액 증가
	public void priceUpdate(PayVo payVo) {
		payDao.priceUpdate(payVo);
	}


	
	//등급별 데이트 횟수 +
	public void rankUpdate(PayVo payVo) {
		payDao.rankUpdate(payVo);
	}
	
	//유저 멤버십 등급 가져오기
	public int userMembership(String buyer) {
		return payDao.userMembership(buyer);
	}
	
	//첫 결제
	public int firstPayment(String buyer) {
		return payDao.firstPayment(buyer);
	}
	
	public void updateFirstPayment(PayVo payVo) {
		payDao.updateFirstPayment(payVo);
	}
	
	public void updateFirst(String buyer) {
		payDao.updateFirst(buyer);
	}
	
	//추가 데이트 횟수 증가
	public void dateCountUpdate(PayVo payVo) {
		payDao.dateCountUpdate(payVo);
	}
	
	//결제 현황 삽입
	public void insertPayState(PayStateVo payStateVo) {
		payDao.insertPayState(payStateVo);
	}
}
