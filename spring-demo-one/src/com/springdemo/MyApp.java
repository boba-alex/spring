package com.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// create
		Coach theCoach = new TrackCoach();
		//use
		System.out.println(theCoach.getDailyWorkout());
	}

}
