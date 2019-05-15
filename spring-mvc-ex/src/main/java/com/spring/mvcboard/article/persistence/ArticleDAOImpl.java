package com.spring.mvcboard.article.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.SearchCriteria;

@Repository
public class ArticleDAOImpl implements ArticleDAO{
	
	@Inject
	private static final String NAMESPACE = "com.spring.mvcboard.mappers.article.ArticleMapper";
	
	@Inject
	private final SqlSession sqlSession;
	
	public ArticleDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void create(ArticleVO articleVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", articleVO);
		
	}

	@Override
	public ArticleVO read(Integer articleNo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", articleNo);
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".update", articleVO);
		
	}

	@Override
	public void delete(Integer articleNo) throws Exception {
		sqlSession.insert(NAMESPACE + ".delete", articleNo);
		
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

	@Override
	public List<ArticleVO> listPaging(int page) throws Exception {
		
		if(page <=0){
			page=1;
		}
		
		page = (page -1)*10;
		
		return sqlSession.selectList(NAMESPACE + ".listPaging", page);
	}

	@Override
    public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
        
		return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
		
    }
	
	@Override
	public int countArticles(Criteria criteria) throws Exception {
 
		return sqlSession.selectOne(NAMESPACE + ".countArticles", criteria);
	}

	@Override
	public List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + ".listSearch", searchCriteria);
	}

	@Override
	public int countSearchArticles(SearchCriteria searchCriteria) throws Exception {

		return sqlSession.selectOne(NAMESPACE + ".countSearchArticles", searchCriteria);
	}



}
