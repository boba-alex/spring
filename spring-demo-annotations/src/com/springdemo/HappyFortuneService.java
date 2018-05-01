package com.springdemo;

import org.springframework.stereotype.Component;

@Component // to scan and register this component-bean!
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "HappyFortuneService!";
	}

}
