package com.spring.mvcboard.commons.paging;

public class SearchCriteria extends Criteria {
	
	private String searchType;
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + ", getSearchType()="
				+ getSearchType() + ", getKeyword()=" + getKeyword() + ", getPage()=" + getPage() + ", getPerPageNum()="
				+ getPerPageNum() + ", getPageStart()=" + getPageStart() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
