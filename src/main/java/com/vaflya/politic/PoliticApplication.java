package com.vaflya.politic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PoliticApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliticApplication.class, args);
	}

}
