package com.date.jum5.user.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.date.jum5.user.pay.mapper.PayMapper;
import com.date.jum5.user.pay.vo.PayStateVo;
import com.date.jum5.user.pay.vo.PayVo;

@Controller
public class PayController {
	
	private PayMapper payMapper;
	
	@Autowired
	public PayController(PayMapper payMapper) {
		this.payMapper = payMapper;
	}
	
	//결제 안내 페이지 요청
	@RequestMapping(value="payGuide")
	public String payGuide() {
		return "/user/pay/payGuide";
	}
	
	//결제 페이지 요청
	@RequestMapping(value="pay")
	public String pay() {
		return "/user/pay/pay";
	}

	
	@ResponseBody
	@RequestMapping(value="payment", method=RequestMethod.POST)
	public int payment(@RequestParam("buyer") String buyer,
			@RequestParam("num") int num, @RequestParam("totalPrice") int totalPrice,
			@RequestParam("price") int onePrice,
			PayVo payVo, PayStateVo payStateVo) {		
		
		int membership = 0;
		int dateCount = 0;
		int count = 0;
		
		int firstPay = payMapper.firstPayment(buyer);
		
		System.out.println("구매자 : "+buyer);
		System.out.println("전체 결제 금액 : "+totalPrice);
		
		payStateVo.setId(buyer);
		payStateVo.setPayPrice(totalPrice);
		
		payMapper.insertPayState(payStateVo);
		
		//첫 결제시 여러개 결제 할 수도 있으므로 첫결제 상태를 0으로 두고
		//0이면 처음 결제한 금액 만큼 멤버십 증가
		if (firstPay==0) {
			//첫 결제가 6000원 일때 (브론즈)
			if (totalPrice>0 && totalPrice<=6000) {
				membership=1;
				dateCount = totalPrice/onePrice;
				payVo.setMembership(membership);
				payVo.setDateCount(dateCount);
				payVo.setPrice(totalPrice);
				payMapper.updateFirstPayment(payVo);
			//첫 결제가 18000원 이상부터 일때 (실버)
			} else if (totalPrice>=18000 && totalPrice<30000) {
				membership=2;
				dateCount = totalPrice/onePrice;
				payVo.setMembership(membership);
				payVo.setDateCount(dateCount);
				payVo.setPrice(totalPrice);
				payMapper.updateFirstPayment(payVo);
			//첫 결제가 30000원 이상부터 일때 (골드)
			} else if (totalPrice>=30000 && totalPrice<42000) {
				membership=3;
				dateCount = totalPrice/onePrice;
				count = 1;
				payVo.setMembership(membership);
				payVo.setDateCount(dateCount);
				payVo.setCount(count);
				payVo.setPrice(totalPrice);
				payMapper.updateFirstPayment(payVo);
			} 
			//첫 결제가 42000원 이상부터 일때 (플래티넘)
			else if (totalPrice>=42000 && totalPrice<60000) {
				membership=4;
				dateCount = totalPrice/onePrice;//7
				count = 2;
				payVo.setMembership(membership);
				payVo.setDateCount(dateCount); //7
				payVo.setCount(count); //2
				payVo.setPrice(totalPrice);
				payMapper.updateFirstPayment(payVo);
			}
			//첫 결제가 60000원 이상부터 일때 (다이아)
			else if (totalPrice>=60000 && totalPrice<90000) {
				membership=5;
				dateCount = totalPrice/onePrice;
				count = 3;
				payVo.setMembership(membership);
				payVo.setDateCount(dateCount);
				payVo.setCount(count);
				payVo.setPrice(totalPrice);
				payMapper.updateFirstPayment(payVo);
				
			//첫 결제가 90000원 이상부터 일때 (vip)
			} else if (totalPrice>=90000) {
				membership=6;
				dateCount = totalPrice/onePrice;
				count = 5;
				payVo.setMembership(membership);
				payVo.setDateCount(dateCount);
				payVo.setCount(count);
				payVo.setPrice(totalPrice);
				payMapper.updateFirstPayment(payVo);
			}
			payMapper.updateFirst(buyer);
		
		} else {
			//추가 결제 금액
			payVo.setPrice(totalPrice);
			payMapper.priceUpdate(payVo);
			
			//기본 데이트 횟수 증가
			dateCount = totalPrice/onePrice;
			payVo.setDateCount(dateCount);
			payMapper.dateCountUpdate(payVo);
			
			int memberPrice = payMapper.price(buyer);
			
			int userMembership = payMapper.userMembership(buyer);
			
			//멤버십 증가 			
			if ((memberPrice>=18000 && memberPrice<30000)) {
				if (userMembership!=2) {
					membership = 2;
					payVo.setMembership(membership);
					payMapper.rankUpdate(payVo);
				}
		 	} else if ((memberPrice>=30000 && memberPrice<42000)) {
				if (userMembership!=3) {
					membership = 3;
					count = 1;
					payVo.setMembership(membership);
					payVo.setCount(count);
					payMapper.rankUpdate(payVo);
				}
				
			} else if ((memberPrice>=42000 && memberPrice<60000)) {
				if (userMembership!=4) {
					membership = 4;
					count = 2;
					payVo.setMembership(membership);
					payVo.setCount(count);
					payMapper.rankUpdate(payVo);
				}
				
			} else if ((memberPrice>=60000 && memberPrice<90000)) {
				if (userMembership!=5) {
					membership = 5;
					count = 3;
					payVo.setMembership(membership);
					payVo.setCount(count);
					payMapper.rankUpdate(payVo);
				}
			} else if ((memberPrice>=90000)) {
				if (userMembership!=6) {
					membership=6;
					count=5;
					payVo.setMembership(membership);
					payVo.setCount(count);
					payMapper.rankUpdate(payVo);
				}
			}
		}

		return 1;
	}
	
}
