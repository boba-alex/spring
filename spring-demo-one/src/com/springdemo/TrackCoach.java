package com.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		super();
	}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Track";
	}

	@Override
	public String getDailyFortune() {	
		return "Track: " + fortuneService.getFortune();
	}
	
	// add init method 
	public void doInitMethod() {
		System.out.println("track: inside init1 method");
	}
	
	// add destroy method
	public void doDestroyMethod() {
		System.out.println("track: inside destroy1 method");
	}
}
