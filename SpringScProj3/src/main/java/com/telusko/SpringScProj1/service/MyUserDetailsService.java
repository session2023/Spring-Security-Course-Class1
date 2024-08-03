package com.telusko.SpringScProj1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.SpringScProj1.dao.UserRepo;
import com.telusko.SpringScProj1.model.Users;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = repo.findByName(username);
		
		if(user==null) {
			
			System.out.println("404 Not Found");
			throw new UsernameNotFoundException("404 user not found");
		}

		return new UserPrinciple(user);
	}
	
	
	
	
	

}
