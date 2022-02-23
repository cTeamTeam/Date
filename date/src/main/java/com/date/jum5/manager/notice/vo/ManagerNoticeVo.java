package com.date.jum5.manager.notice.vo;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("NoticeVo")
public class ManagerNoticeVo {

	private int num;
	private String title;
	private String content;
	private Timestamp date;
	private int count;
	
	public ManagerNoticeVo() {}
	
	public ManagerNoticeVo(String title, String content) {
		super();
		this.title=title;
		this.content=content;
		this.count=0;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
