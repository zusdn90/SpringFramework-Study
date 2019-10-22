package com.spring.mvcboard.reply;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/reply")
public class ReplyTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@RequestMapping("/test")
	public String replyAjaxTest(){
		
		logger.info("reply Ajax Test....");
		
		return "/tutorial/reply_test";
	}

}
