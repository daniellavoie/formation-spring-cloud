package com.invivoo.spring.cloud.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invivoo.spring.cloud.validationservice.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
}
