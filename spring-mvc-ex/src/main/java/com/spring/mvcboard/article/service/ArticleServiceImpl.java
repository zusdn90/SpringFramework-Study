package com.spring.mvcboard.article.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.article.persistence.ArticleDAO;
import com.spring.mvcboard.commons.paging.Criteria;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	private final ArticleDAO articleDAO;
	
	@Inject
	public ArticleServiceImpl(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public void create(ArticleVO articleVO) throws Exception {
	
		articleDAO.create(articleVO);
	}

	@Override
	public ArticleVO read(Integer articleNo) throws Exception {

		return articleDAO.read(articleNo);
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
	
		articleDAO.update(articleVO);
	}

	@Override
	public void delete(Integer articleNo) throws Exception {
		articleDAO.delete(articleNo);
		
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		
		return articleDAO.listAll();
	}

	@Override
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
		
		return articleDAO.listCriteria(criteria);
	}

}
