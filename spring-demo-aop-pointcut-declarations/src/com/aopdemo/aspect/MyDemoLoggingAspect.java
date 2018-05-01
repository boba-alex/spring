package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {	
	// related advices for logging	start with @Before advice
	
	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> API Analytics");
	}
}
