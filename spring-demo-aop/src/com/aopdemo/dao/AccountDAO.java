package com.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {
	
	public boolean addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + "doing db work : adding an account");
	
		return true;
	}
	
	public boolean doWork() {
		System.out.println(getClass() + "doing db work : doing work");
		
		return false;
	}
}
