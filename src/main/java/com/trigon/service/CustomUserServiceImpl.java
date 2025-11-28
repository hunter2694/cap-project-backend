package com.trigon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trigon.entity.User;
import com.trigon.repository.UserRepository;

@Service
public class CustomUserServiceImpl implements UserDetailsService{

	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =repo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found with entered mail ::"+username);
		}
		
		List<GrantedAuthority> authority=new ArrayList<>();
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authority);
	}
	

}