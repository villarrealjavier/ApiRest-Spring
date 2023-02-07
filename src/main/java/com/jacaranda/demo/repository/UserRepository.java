package com.jacaranda.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.demo.model.User;




public interface UserRepository extends JpaRepository<User, String> { 
	List<User> findByEmail(String email);
//	List<User> findByUsername(String username);
	

}
