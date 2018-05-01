package com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====> @After(finally)method: " + method);
	}

	@AfterThrowing(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint joinPoint, Throwable theExc) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====> @AfterThrowing: " + method);
		
		//log the exception
		System.out.println("\n=====> The exc is: " + theExc);
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n=====> @AfterReturning: " + method);
		
		System.out.println("\n=====> Result: " + result);
		
		//MODIFYING DATA
		convertAccountNamesToUpperCase(result);
		
		System.out.println("result: " + result);
		
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account account : result) {
			
			String toUpperCase = account.getName().toUpperCase();
			
			account.setName(toUpperCase);
		}
	}

	@Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on method");
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		
		//arguments
		Object[] args = joinPoint.getArgs();
		
		for(Object object : args) {
			System.out.println(object);
			
			if(object instanceof Account) {
				
				Account account = (Account) object;
				
				System.out.println("name " + account.getName());
				System.out.println("level " + account.getLevel());
			}
		}
	}
	
}
