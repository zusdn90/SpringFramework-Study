package com.spring.mvcboard.reply.service;

import java.util.List;

import com.spring.mvcboard.reply.domain.ReplyVO;

public interface ReplyService {
	List<ReplyVO> list(Integer articleNo) throws Exception;
	
	void create(ReplyVO replyVO)throws Exception;
	
	void update(ReplyVO replyVO)throws Exception;
	
	void delete(Integer replyNo)throws Exception;
}
