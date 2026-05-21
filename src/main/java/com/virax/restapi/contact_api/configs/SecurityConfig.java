package com.virax.restapi.contact_api.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // for multi static users auth
public class SecurityConfig {
	
//	CSRF disble Only
//	@Bean
//	public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception{
//		
//		return http.csrf(AbstractHttpConfigurer::disable).build();
//	}
	
	// for multi static users auth
	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
		
		return http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests( auth -> auth.anyRequest().authenticated()) // for static user based auth
				.httpBasic(Customizer.withDefaults()) // for static user based auth
				.build();
	}
	
	@Bean
	public UserDetailsService getUserDetailsService(PasswordEncoder passwordEncoder) {
		
		UserDetails raj = User.builder()
				.username("raj")
				.password(passwordEncoder.encode("raj1"))
				.roles("DEV")
				.build();
		
		UserDetails venkat = User.builder()
				.username("venkat")
				.password(passwordEncoder.encode("venkat1"))
				.roles("USER")
				.build();
		
		UserDetails gani = User.builder()
				.username("gani")
				.password(passwordEncoder.encode("gani1"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(raj,venkat,gani);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
