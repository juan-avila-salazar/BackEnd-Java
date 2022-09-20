package com.ej5.commandlinerunner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("Soy la tercera clase ");
	}
	@Override
	public void run(String... args) throws Exception {
		log.info("Hola desde la clase Seundaria");

	}
}
