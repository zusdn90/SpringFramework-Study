package com.spring.mvcboard.commons.paging;

//게시판 하단의 페이지 번호 출력
public class PageMaker {
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	//하단의 페이지 번호의 갯수
	private int displayPageNum = 10;
	
	private Criteria criteria;
	
	public void setCriteria(Criteria criteria){
		this.criteria = criteria;
	}
	
	public Criteria getCriteria() {
		return criteria;
	}
	
	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
		calcData();
	}
	
	private void calcData(){
		
		//끝 페이지 번호
		endPage = (int)Math.ceil(criteria.getPage() / (double) displayPageNum);
		
		//시작 페이지 번호
		startPage = (endPage - displayPageNum) + 1;
		
		//이전 페이지 번호 계싼
		int tempEndPage = (int)(Math.ceil(totalCount / (double) criteria.getPerPageNum()));
		
		if(endPage > tempEndPage){
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		
		next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
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

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	

}
