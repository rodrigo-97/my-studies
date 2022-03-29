package com.app.mystudies.msteatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsTeatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTeatcherApplication.class, args);
	}

}
