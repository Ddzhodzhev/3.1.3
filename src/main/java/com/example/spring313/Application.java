package com.example.spring313;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.spring313")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
