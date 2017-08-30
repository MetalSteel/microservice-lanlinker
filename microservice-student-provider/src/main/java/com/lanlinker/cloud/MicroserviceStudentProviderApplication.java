package com.lanlinker.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceStudentProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceStudentProviderApplication.class, args);
	}
}
