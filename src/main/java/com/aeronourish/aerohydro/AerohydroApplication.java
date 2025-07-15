package com.aeronourish.aerohydro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class AerohydroApplication {

	public static void main(String[] args) {

		SpringApplication.run(AerohydroApplication.class, args);
	}

}
