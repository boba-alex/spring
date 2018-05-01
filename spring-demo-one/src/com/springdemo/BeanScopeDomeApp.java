package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDomeApp {

	public static void main(String[] args) {
		
		//load spr conf
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alfhaCoach = context.getBean("myCoach", Coach.class);
		
		//check if beans same
		boolean result = (theCoach == alfhaCoach);
		
		//results
		System.out.println("Same objects " + result);
		
		System.out.println("Memory location thecoach" + theCoach);
		
		System.out.println("Memory location alphacoach" + alfhaCoach);
		
		
		//close the context
		context.close();
	}

}
