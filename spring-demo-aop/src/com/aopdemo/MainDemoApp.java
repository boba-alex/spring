package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the bus method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		
		membershipDAO.addAccount();
		
		accountDAO.doWork();
		
		membershipDAO.goToSleep();
		
		//close the context
		context.close();
	}

}
