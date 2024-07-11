package com.telusko.SpringScProj1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {
	
	
	@Bean
	public SecurityFilterChain csecurityFilterChain(HttpSecurity http) throws Exception {
		
//		http.csrf(Customizer->Customizer.disable());
//		http.authorizeHttpRequests(request->request.anyRequest().authenticated());
//		http.httpBasic(Customizer.withDefaults());
//		http.formLogin(Customizer.withDefaults());
//		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		
//		return http.build();
		
		
		//Same method as above
		http.csrf(Customizer->Customizer.disable())
		.authorizeHttpRequests(request->request.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
	}

}
