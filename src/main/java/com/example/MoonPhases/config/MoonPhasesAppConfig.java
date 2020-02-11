package com.example.MoonPhases.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.MoonPhases.methods.MoonPhasesMethods;

@Configuration
public class MoonPhasesAppConfig {

	@Bean
	public MoonPhasesMethods moonPhasesMethods() {
		return new MoonPhasesMethods();
	}
}
