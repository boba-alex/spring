package com.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from spring container
		TrafficFortuneService trafficFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("Main program");
		
		myLogger.info("getFortune");
		
		boolean tripWire = true;		
		String data = trafficFortuneService.getFortune(tripWire);
		
		myLogger.info("My Fortune is: " + data);
		
		myLogger.info("Finished");
		
		//close the context
		context.close();
	}

}
