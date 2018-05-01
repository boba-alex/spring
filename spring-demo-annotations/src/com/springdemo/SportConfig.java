package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	//define for fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//define for swim and inject dependencies
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
	
}
