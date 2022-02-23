package com.date.jum5.user.login.vo;

public class LoginVo {

	private String id;
	private String oldPw;
	private String password;
	private String name;
	private String birth;
	private String nickname;
	private String email;
	private String memberShip;
	private int datecount;
	
	
	public int getDatecount() {
		return datecount;
	}
	public void setDatecount(int datecount) {
		this.datecount = datecount;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMemberShip() {
		return memberShip;
	}
	public void setMemberShip(String memberShip) {
		this.memberShip = memberShip;
	}
	public String getOldPw() {
		return oldPw;
	}
	public void setOldPw(String oldPw) {
		this.oldPw = oldPw;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMembership() {
		return memberShip;
	}
	public void setMembership(String membership) {
		this.memberShip = membership;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
