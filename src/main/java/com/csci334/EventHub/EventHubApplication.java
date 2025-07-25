package com.csci334.EventHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EventHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventHubApplication.class, args);
	}
}
