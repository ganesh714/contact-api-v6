package com.virax.restapi.contact_api.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
	
	@Bean
	public OpenAPI contactAppOpenAPI() {
		return new OpenAPI().info(
				new Info()
				.title("Contact app open API specs")
				.description("this contains all end points docs")
				);
	}
}
