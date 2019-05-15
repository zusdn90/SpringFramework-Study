package com.spring.mvcboard.article.persistence;

import java.util.List;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.SearchCriteria;

public interface ArticleDAO {
	
	
	void create(ArticleVO articleVO) throws Exception;
	
	ArticleVO read(Integer articleNo) throws Exception;
	
	void update(ArticleVO articleVO) throws Exception;
	
	void delete(Integer articleNo) throws Exception;
	
	List<ArticleVO> listAll() throws Exception;
	
	//페이징 처리
    List<ArticleVO> listPaging(int page) throws Exception;

    List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
    
    //페이징 처리를 위한 전체 게시글의 갯수
    int countArticles(Criteria criteria) throws Exception;
    
    //검색처리
    List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception;
	
    int countSearchArticles (SearchCriteria searchCriteria) throws Exception;
}
