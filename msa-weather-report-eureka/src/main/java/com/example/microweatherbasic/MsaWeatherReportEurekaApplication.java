package com.example.microweatherbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsaWeatherReportEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaWeatherReportEurekaApplication.class, args);
	}
}
