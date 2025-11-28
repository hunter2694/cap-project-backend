package com.trigon.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.trigon.entity.User;
public interface UserRepository extends JpaRepository<User,Long>{

	
	public User findByEmail(String mail);
}
