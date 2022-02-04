package com.date.jum5.user.question.vo;

public class PagingVo {
	
	//한 페이지에 출력할 글 수
	private final int pageSize=10;
	//현재 페이지
	private int currentPage;
	//해당 페이지에 시작할 레코드 번호
	private int startRow;
	//해당 페이지의 마지막 레코드 번호
	private int endRow;
	//총 페이지 수 
	private int pageCount;
	//한 페이지에 보여줄 페이지 수
	private final int pageBlock=5;
	//한 화면에 시작할 페이지 번호
	private int startPage;
	//한 화면의 마지막 페이지 번호
	private int endPage;
	//실제 화면에 보여질 페이지 수
	private int realEndPage;
	
	public int getRealEndPage() {
		return realEndPage;
	}
	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	
	
}
