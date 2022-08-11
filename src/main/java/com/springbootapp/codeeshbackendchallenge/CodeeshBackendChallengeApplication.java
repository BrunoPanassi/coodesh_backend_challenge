package com.springbootapp.codeeshbackendchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CodeeshBackendChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeeshBackendChallengeApplication.class, args);
	}

}
