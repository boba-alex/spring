package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts();
		
		System.out.println("\n\nMain program: After Returning");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		//close the context
		context.close();
	}

}
