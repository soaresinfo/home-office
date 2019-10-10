package com.br.everis.homeoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HomeOfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeOfficeApplication.class, args);
	}
	
}
