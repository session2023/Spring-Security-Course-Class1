package com.telusko.SpringScProj1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController()
public class InfoController {
	
	
	@GetMapping("/info")
	public String getTeluskoInfo(HttpServletRequest request) {
		
		return "Telusko is planning to launch simplified Devops Course" +request.getSession().getId();
	}

	
	
	@GetMapping("/devops")
	public String getTeluskoInfoOnCourse(HttpServletRequest request) {
		
		return "Simplified Devops Course and it will be for 2.5 months" +request.getSession().getId();
	}
}
