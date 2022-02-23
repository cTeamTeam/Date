package com.date.jum5.user.metch.vo;

public class MetchVo {
	private int idx;
	private String senderId;
	private String receiverId;
	private int metch_status;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public int getMetchStatus() {
		return metch_status;
	}
	public void setMetchStatus(int metch_status) {
		this.metch_status = metch_status;
	}
	@Override
	public String toString() {
		return "MetchVo [idx=" + idx + ", senderId=" + senderId + ", receiverId=" + receiverId + ", metch_status="
				+ metch_status + "]";
	}
	
	
	
}
