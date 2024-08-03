package com.telusko.SpringScProj1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {
	
	private UserDetailsService service;
	
	
	@Bean
	public SecurityFilterChain csecurityFilterChain(HttpSecurity http) throws Exception {
		

	
		//Same method as above
		http.csrf(Customizer->Customizer.disable())
		.authorizeHttpRequests(request->request.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
		
	}
	
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(service);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		
		return provider;
		
		
	}


}
