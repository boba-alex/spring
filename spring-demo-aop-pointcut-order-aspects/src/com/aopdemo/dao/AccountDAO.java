package com.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public boolean addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + "doing db work : adding an account");
	
		return true;
	}
	
	public boolean doWork() {
		System.out.println(getClass() + "doing db work : doing work");
		
		return false;
	}

	public String getName() {
		System.out.println(getClass() + "getter name");	
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + "setter name");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + "getter code");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + "setter code");
		this.serviceCode = serviceCode;
	}
	
	
}
