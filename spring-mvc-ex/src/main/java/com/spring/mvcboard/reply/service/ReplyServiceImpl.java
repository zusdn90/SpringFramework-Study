package com.spring.mvcboard.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.mvcboard.article.persistence.ArticleDAO;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.reply.domain.ReplyVO;
import com.spring.mvcboard.reply.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Inject
	private final ReplyDAO replyDAO;
	
	@Inject
	private final ArticleDAO articleDAO;
		
	public ReplyServiceImpl(ReplyDAO replyDAO, ArticleDAO articleDAO) {
		this.replyDAO = replyDAO;
		this.articleDAO = articleDAO;
	}

	

	@Override
	public List<ReplyVO> getRepliesPaging(Integer articleNo, Criteria criteria) throws Exception {

		return replyDAO.listPaging(articleNo, criteria);
	}

	@Override
	public int countReplies(Integer articleNo) throws Exception {

		return replyDAO.countReply(articleNo);
	}



	@Override
	public List<ReplyVO> getReplies(Integer articleNo) throws Exception {
		 return replyDAO.list(articleNo);
	}



	@Override
	public void addReply(ReplyVO replyVO) throws Exception {
		replyDAO.create(replyVO);
		
	}

	@Override
	public void modifyReply(ReplyVO replyVO) throws Exception {
		 replyDAO.update(replyVO);
	}

	@Override
	public void removeReply(Integer replyNo) throws Exception {
		int articleNo = replyDAO.getArticleNo(replyNo);
		replyDAO.delete(replyNo);
	}

}
