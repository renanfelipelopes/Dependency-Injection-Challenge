package com.example.challenge.dependencyInjection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInjectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DependencyInjectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Teste");
	}

}
