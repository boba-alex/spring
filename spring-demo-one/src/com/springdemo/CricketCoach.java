package com.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	private String emailAddress;
	private String  team;
	
	//create non-constructor
	public CricketCoach() {
		System.out.println("Cricketcoach: inside no-arg constr");
	}	
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricketcoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricketcoach: inside setter method - setTeam");
		this.team = team;
	}

	//setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricketcoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "cricket workout";
	}


	@Override
	public String getDailyFortune() {
		return "cricket " + fortuneService.getFortune();
	}

}
