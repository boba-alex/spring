package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService trafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Main program");
		
		System.out.println("getFortune");
		
		String data = trafficFortuneService.getFortune();
		
		System.out.println("My Fortune is: " + data);
		
		System.out.println("Finished");
		
		//close the context
		context.close();
	}

}
