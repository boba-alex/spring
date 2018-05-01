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
		account.setName("algerd");
		account.setLevel("1st level");
		accountDAO.addAccount(account, true);		
		accountDAO.doWork();
		
		//setter/getter
		accountDAO.setName("foobar");
		accountDAO.setName("Silver");
		
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		membershipDAO.addAccount();
		membershipDAO.goToSleep();
		
		//close the context
		context.close();
	}

}
