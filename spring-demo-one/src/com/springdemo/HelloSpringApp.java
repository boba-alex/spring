package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring conf file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods from bean
		System.out.println(theCoach.getDailyWorkout());
		
		//fortune methods
		System.out.println(theCoach.getDailyFortune());
				
		//close context
		context.close();

	}

}
