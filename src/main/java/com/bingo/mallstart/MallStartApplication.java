package com.bingo.mallstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.bingo.mallstart"})
@SpringBootApplication
public class MallStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallStartApplication.class, args);
	}

}
