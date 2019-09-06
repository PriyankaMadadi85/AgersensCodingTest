package com.agersens.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.agersens.demo"})
public class AgersensApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgersensApplication.class, args);
	}

}
