package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load spr config
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from spr container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach theCCCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean res = (theCCCoach == theCoach);
		
		System.out.println("res: " + res);
		
		System.out.println("memory" + theCoach);
		
		System.out.println("memory" + theCCCoach);
		
		context.close();
	}

}
