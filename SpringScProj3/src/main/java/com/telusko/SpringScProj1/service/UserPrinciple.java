package com.telusko.SpringScProj1.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.telusko.SpringScProj1.model.Users;

public class UserPrinciple implements UserDetails{
	
	private Users user;
	

	public UserPrinciple(Users user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getName();
	}

}
