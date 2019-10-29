package test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.reply.domain.ReplyVO;
import com.spring.mvcboard.reply.persistence.ReplyDAO;
import com.spring.mvcboard.reply.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/applicationContext.xml"})
public class ReplyDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);

    @Inject
    private ReplyDAO replyDAO;

    @Inject
    private ReplyService replyService;

    @Test
    public void testReplyCreateService() throws Exception {
        for (int i = 1; i <= 300; i++) {
            ReplyVO replyVO = new ReplyVO();
            replyVO.setArticleNo(1994);
            replyVO.setReplyText(i+"번째 댓글입니다..");
            replyVO.setReplyWriter("user0"+(i%10));

            replyService.addReply(replyVO);
        }
    }
}