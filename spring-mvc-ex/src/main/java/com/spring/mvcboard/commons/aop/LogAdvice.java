package com.spring.mvcboard.commons.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component	//스프링 빈으로 인식되기 위한 어노테이션
@Aspect		//AOP 기능을 하는 클래스에 반드시 추가해야할 어노테이션
public class LogAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	@Around("execution(* com.spring.mvcboard..*Controller.*(..))"
	       + " or execution(* com.spring.mvcboard..service..*Impl.*(..))"
	       + " or execution(* com.spring.mvcboard..persistence..*Impl.*(..))")			//메서드 실행 전체를 앞,뒤로 감싸서 특정한 기능을 실행할 수 있는 강력한 타입의 Advice
	public Object logPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object result = proceedingJoinPoint.proceed();	//proceed() -> 다음 Advice를 실행하거나, 실제 target객체의 메서드를 실행하는 기능을 가진 메서드
		
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		String name = "";
		
		if(type.contains("Controller")){
			name = "Controller : ";
		}else if (type.contains("Service")){
            name = "Service : ";
        }else if (type.contains("DAO")){
            name = "Persistence : ";
        }
		
		long end = System.currentTimeMillis();
		
		logger.info(name + type + "."+proceedingJoinPoint.getSignature().getName() + "()");		//getSignature(): 실행하는 대상 객체의 메서드에 대한 정보를 알아낼 때 사용한다.
        logger.info("Argument/Parameter : " + Arrays.toString(proceedingJoinPoint.getArgs()));	//getArgs : 전달되는 모든 파라미터들을 Object의 배열로 가져온다.
        logger.info("Running Time : " + (end-start));
        logger.info("----------------------------------------------------------------");
        
        return result;		//@Around는 반드시 리턴타입을 Object로 선언해줘야만 한다.
	}

}
