package com.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("inside def constr");
	}
	
	//define init met
	@PostConstruct
	public void startMethod() {
		System.out.println("start method 1");
	}
	
	//define destr meth
	@PreDestroy
	public void finishMethod() {
		System.out.println("finish method 1");
	}

	//setter
	//@Autowired
	//public void AAAAAsetFortuneService(FortuneService fortuneService) {
	//	System.out.println("setter");
	//	this.fortuneService = fortuneService;
	//}
	
	
	//@Autowired
	//public TennisCoach(FortuneService theFortuneServ) {
	//	fortuneService = theFortuneServ;
	//}

	@Override
	public String getDailyWorkout() {
		return "tennis-coach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
