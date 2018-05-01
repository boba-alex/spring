package com.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService trafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("Main program");
		
		myLogger.info("getFortune");
		
		String data = trafficFortuneService.getFortune();
		
		myLogger.info("My Fortune is: " + data);
		
		myLogger.info("Finished");
		
		//close the context
		context.close();
	}

}
