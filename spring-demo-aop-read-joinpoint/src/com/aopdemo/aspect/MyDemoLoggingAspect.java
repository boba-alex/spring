package com.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
	// related advices for logging	start with @Before advice
	
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
