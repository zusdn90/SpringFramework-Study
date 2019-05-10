package com.spring.mvcboard.article;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.article.persistence.ArticleDAO;
import com.spring.mvcboard.commons.paging.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/applicationContext.xml"})
public class ArticleDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

    @Inject
    private ArticleDAO articleDAO;

    @Test
    public void testCreate() throws Exception {

        for (int i = 1; i <= 1000; i++) {
            ArticleVO articleVO = new ArticleVO();
            articleVO.setTitle(i+ "번째 글 제목입니다...");
            articleVO.setContent(i+ "번재 글 내용입니다...");
            articleVO.setWriter("user0"+(i%10));

            articleDAO.create(articleVO);
        }

    }

//    @Test
//    public void testRead() throws Exception {
//        logger.info(articleDAO.read(1).toString());
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        ArticleVO article = new ArticleVO();
//        article.setArticleNo(1);
//        article.setTitle("글 수정 테스트 제목");
//        article.setContent("글 수정 테스트 내용");
//        articleDAO.update(article);
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        articleDAO.delete(1);
//    }
//
//    @Test
//    public void testListPaging() throws Exception {
//
//        int page = 3;
//
//        List<ArticleVO> articles = articleDAO.listPaging(page);
//
//        for (ArticleVO article : articles) {
//            logger.info(article.getArticleNo() + ":" + article.getTitle());
//        }
//
//    }
//
//    @Test
//    public void testListCriteria() throws Exception {
//        Criteria criteria = new Criteria();
//        criteria.setPage(3);
//        criteria.setPerPageNum(20);
//
//        List<ArticleVO> articles = articleDAO.listCriteria(criteria);
//
//        for (ArticleVO article : articles) {
//            logger.info(article.getArticleNo() + " : " + article.getTitle());
//        }
//    }
}