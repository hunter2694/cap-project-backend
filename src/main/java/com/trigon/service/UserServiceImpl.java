package com.trigon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trigon.config.JwtProvider;
import com.trigon.entity.User;
import com.trigon.exeption.UserException;
import com.trigon.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User findUserById(Long id) throws UserException {
		
		Optional<User> optional= userRepo.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		throw new UserException("User not found with the id :: "+id);
	}

	@Override
	public User findUserProfileByjwt(String jwt) throws UserException {
		
		String email = jwtProvider.getMailFromToken(jwt);
		System.out.println("Extracted email from JWT: " + email);
		User user=userRepo.findByEmail(email);
		
		
		if(user==null) {
			throw new UserException("User is not present for given email ::"+email);
		}
		
		return user;
	}

}
