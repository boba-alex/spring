package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//call method of the bean
		System.out.println(theCoach.getDailyWorkout());
				
		// call daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//call new methods
		System.out.println(theCoach.getEmail());
		
		System.out.println(theCoach.getTeam());
		
		//close the context
		context.close();
		
		
		
	}

}
