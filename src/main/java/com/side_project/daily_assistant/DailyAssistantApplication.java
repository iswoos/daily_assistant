package com.side_project.daily_assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DailyAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyAssistantApplication.class, args);
	}

}
