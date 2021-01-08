package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReclamationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamationApplication.class, args);
	}
	
	@Autowired
	private ReclamationRepository repository;
	
	@Bean
	ApplicationRunner init() {
		return (args) -> {
			// save			
			repository.save(new Reclamation("rec", "non satisfaisant",true,"oui"));
			repository.save(new Reclamation("rec", "non satisfaisant",true,"oui"));
			repository.save(new Reclamation("rec", "non satisfaisant",true,"oui"));
			// fetch
			repository.findAll().forEach(System.out::println);

		};
	}

}
