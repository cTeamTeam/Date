package com.date.jum5.user.pay.vo;

public class PayVo {
	
	//이름
	private String buyer;
	private int price;
	//데이트 횟수
	private int dateCount;
	//추가 데이트 횟수
	private int count;
	//멤버십
	private int membership;
	
	public int getDateCount() {
		return dateCount;
	}
	public void setDateCount(int dateCount) {
		this.dateCount = dateCount;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMembership() {
		return membership;
	}
	public void setMembership(int membership) {
		this.membership = membership;
	}
	
	
	
	
}
