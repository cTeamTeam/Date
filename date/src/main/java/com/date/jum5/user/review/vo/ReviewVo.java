package com.date.jum5.user.review.vo;

public class ReviewVo {

	int seq;
	String title;
	String content;
	String name;
	String regDate;
	String readCount;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getReadCount() {
		return readCount;
	}
	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}
	
	@Override
	public String toString() {
		return "ReviewVo [seq=" + seq + ", title=" + title + " , content=" + content + " , name=" + name + " , regDate=" + regDate + ""
				+ " readCount=" + readCount + "]";
	}
}