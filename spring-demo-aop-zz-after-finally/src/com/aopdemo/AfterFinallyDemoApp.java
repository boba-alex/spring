package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = null;
		
		try {
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch(Exception ex) {
			System.out.println("\n\n exception in main" + ex);
		}
		
		System.out.println("\n\nMain program: After Throwing");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		//close the context
		context.close();
	}

}
