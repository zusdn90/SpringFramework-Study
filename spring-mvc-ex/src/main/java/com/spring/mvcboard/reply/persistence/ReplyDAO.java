package com.spring.mvcboard.reply.persistence;

import java.util.List;

import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.reply.domain.ReplyVO;

public interface ReplyDAO {
	List<ReplyVO> list(Integer articleNo) throws Exception;
	
	void create(ReplyVO replyVO)throws Exception;
	void update(ReplyVO replyVO)throws Exception;
	void delete(Integer replyNo)throws Exception;
	
	//페이징처리 메서드
	List<ReplyVO> listPaging(Integer articleNo, Criteria criteria) throws Exception;
	int countReply(Integer articleNo) throws Exception;
	
	int getArticleNo(Integer replyNo) throws Exception;
}
