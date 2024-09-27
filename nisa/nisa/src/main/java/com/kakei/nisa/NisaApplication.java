package com.kakei.nisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class NisaApplication {

		public static void main(String[] args) {
			SpringApplication.run(NisaApplication.class, args);
		}

	}
