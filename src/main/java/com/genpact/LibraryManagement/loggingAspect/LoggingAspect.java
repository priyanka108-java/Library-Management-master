package com.genpact.LibraryManagement.loggingAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
@Aspect
public class LoggingAspect {
	
	Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	//Where do we apply
	@Pointcut(value="execution( * com.genpact.LibraryManagement.*.*.*(..))")
	public void myPointCut() {
		
	}
	
	//Advice -- How do we apply
	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] args = pjp.getArgs();
		log.info("Method called :"+className+" : "+methodName+"()"+" arguments : "+objectMapper.writeValueAsString(args));
		Object object = pjp.proceed();
		log.info("Method response "+className+" : "+methodName+ "()"+"Response "+ objectMapper.writeValueAsString(object));
		return object;
	}

}
