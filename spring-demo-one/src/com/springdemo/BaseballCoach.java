package com.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneservice
		return fortuneService.getFortune();
	}
}
