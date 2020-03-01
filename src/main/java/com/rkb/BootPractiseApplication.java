package com.rkb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootPractiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootPractiseApplication.class, args);
	}

}
