package com.bhavna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EmployeeNaukriServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeNaukriServerApplication.class, args);
	}

}
