package com.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	
	//create an array of str
	private String[] data = {"aaa", "bbb", "ccc", "ddd", "eee"};
	
	//create a rand
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		//pick rand from array
		int randIndex = myRandom.nextInt(data.length);
		
		String theFortune = data[randIndex];
		
		return theFortune;
	}

}
