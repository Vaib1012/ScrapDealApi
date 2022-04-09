package com.ibm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class ScrapDealApplication {	
	public static void main(String[] args) {
		SpringApplication.run(ScrapDealApplication.class, args);
	}
}
