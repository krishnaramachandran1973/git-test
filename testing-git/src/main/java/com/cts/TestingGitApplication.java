package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingGitApplication {

	public static void main(String[] args) {
		System.out.println("Coding done by developer A");
		System.out.println("Coding done by developer B");
		SpringApplication.run(TestingGitApplication.class, args);
	}

}
