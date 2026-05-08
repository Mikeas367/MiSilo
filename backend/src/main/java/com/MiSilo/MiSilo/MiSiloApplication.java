package com.MiSilo.MiSilo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MiSiloApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiSiloApplication.class, args);
	}

}
