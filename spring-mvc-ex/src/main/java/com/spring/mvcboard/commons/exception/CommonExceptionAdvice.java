package com.spring.mvcboard.commons.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice 			//컨트롤러에서 발생하는 Exception을 전문적으로 처리하는 클래스라는 것을 명시
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView commonException(Exception e){
		
		logger.info(e.toString());
		
		//ModelAndView 객체는 하나의 객체에 Model 데이터와 View의 처리를 동시에 처리할 수 있는 객체
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("exception",e);
		modelAndView.setViewName("/commons/common_error");
		
		return modelAndView;
	}

}
