package com.be_servicie.saigon_travel.be_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootApplication
@EnableJpaAuditing
public class BeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BeServiceApplication.class, args);
	}
}
