package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		
		System.out.println(getClass() + "doing db work membership: adding an account");
	}
	
	public void goToSleep() {
		System.out.println(getClass() + "sleep");
		
	}
}
