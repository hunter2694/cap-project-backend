package com.trigon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordGenerator {

	@Bean
	BCryptPasswordEncoder getPassswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
