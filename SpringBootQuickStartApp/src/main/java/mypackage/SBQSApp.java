package mypackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // starting point for spring boot application
public class SBQSApp {

	public static void main(String[] args) {

		SpringApplication.run(SBQSApp.class, args); //parse class with main method, it creates servlet container
	}
}
