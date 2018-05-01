package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//load spring conf file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retieve bean from spr cont
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		//call our methods get literals
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		//close context
		context.close();
	}

}
