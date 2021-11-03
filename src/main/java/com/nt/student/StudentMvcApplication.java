package com.nt.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.qos.logback.core.encoder.Encoder;

@SpringBootApplication
public class StudentMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMvcApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
