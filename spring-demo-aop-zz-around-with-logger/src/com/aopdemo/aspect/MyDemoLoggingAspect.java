package com.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {	
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====> @Around method: " + method);
	
		long begin = System.currentTimeMillis();
		
		Object result = proceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=====> @After(finally)method: " + method);
	}

	@AfterThrowing(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint joinPoint, Throwable theExc) {
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=====> @AfterThrowing: " + method);
		
		//log the exception
		myLogger.info("\n=====> The exc is: " + theExc);
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("\n=====> @AfterReturning: " + method);
		
		myLogger.info("\n=====> Result: " + result);
		
		//MODIFYING DATA
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("result: " + result);
		
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account account : result) {
			
			String toUpperCase = account.getName().toUpperCase();
			
			account.setName(toUpperCase);
		}
	}

	@Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		myLogger.info("\n=====>>> Executing @Before advice on method");
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		myLogger.info("Method: " + methodSignature);
		
		//arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object object : args) {
			myLogger.info(object.toString());
			
			if(object instanceof Account) {
				
				Account account = (Account) object;
				
				myLogger.info("name " + account.getName());
				myLogger.info("level " + account.getLevel());
			}
		}
	}
	
}
