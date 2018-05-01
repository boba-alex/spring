package com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		//display method
		String method = joinPoint.getSignature().toShortString();
		logger.info("======> @Before: calling method: " + method);
		
		//display arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object tempArg : args) {
			logger.info("======> argument: " + tempArg);
		}
		
	}
	
	// add @AfterRet
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("======> @AfterReturning: calling method: " + method);
		
		logger.info("=====> result: " + result);
		
	}
	
	
	
	
	
	
}
