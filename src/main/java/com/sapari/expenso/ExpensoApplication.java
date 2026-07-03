package com.sapari.expenso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class ExpensoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensoApplication.class, args);
	}

}
