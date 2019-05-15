package com.spring.mvcboard.commons.paging;


//페이징 처리의 기준이 되는 변수 처리
public class Criteria {
	
	private int page;			//현재 페이지 번호
	private int perPageNum;		//페이지 당 출력되는 게시글의 갯수
	
	
	//기본 생성자, 현재 페이지를 1, 페이지 당 출력할 게시글의 갯수를 10으로 기본세팅
	public Criteria() {
        this.page = 1;
        this.perPageNum = 10;
    }

    // page validation 체크
    public void setPage(int page) {

        if (page <= 0) {
            this.page = 1;
            return;
        }

        this.page = page;
    }

    // perPageNum validation 체크
    public void setPerPageNum(int perPageNum) {

        if (perPageNum <= 0 || perPageNum > 100) {
            this.perPageNum = 20;
            return;
        }

        this.perPageNum = perPageNum;
    }

    public int getPage() {
        return page;
    }

    // for MyBatis SQL Mapper
    public int getPerPageNum() {
        return this.perPageNum;
    }

    // for MyBatis SQL Mapper
    public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "page=" + page +
                ", perPageNum=" + perPageNum +
                '}';
    }

}
