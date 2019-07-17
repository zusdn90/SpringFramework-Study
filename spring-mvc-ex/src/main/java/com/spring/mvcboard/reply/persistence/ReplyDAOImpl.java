package com.spring.mvcboard.reply.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.mvcboard.reply.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	
	@Inject
	private static final String NAMESPACE = "com.spring.mvcboard.mappers.reply.ReplyMapper";
	
	@Inject
	private final SqlSession sqlSession;
	
	public ReplyDAOImpl(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	
	@Override
	public List<ReplyVO> list(Integer articleNo) throws Exception {
		
		return sqlSession.selectList(NAMESPACE + ".list", articleNo);
	}

	@Override
	public void create(ReplyVO replyVO) throws Exception {
		
		sqlSession.insert(NAMESPACE + "create", replyVO);
	}

	@Override
	public void update(ReplyVO replyVO) throws Exception {
		
		sqlSession.update(NAMESPACE + "update", replyVO);
	}

	@Override
	public void delete(Integer replyNo) throws Exception {
		
		sqlSession.delete(NAMESPACE + "delete", replyNo);
	}

	

}
