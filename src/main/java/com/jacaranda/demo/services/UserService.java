package com.jacaranda.demo.services;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jacaranda.demo.model.User;
import com.jacaranda.demo.repository.UserRepository;



@Service
public class UserService implements UserDetailsService{
	@Autowired
	UserRepository repository;
	
	
	
//	public boolean checkExist(User s) {
//	boolean resultado = false;
//	// Comprueba que no existe el nombre del usuario
//	
//	User checkUser = repository.findById(s.getUsername()).orElse(null);
//	List<User> checkEmail = repository.findByEmail(s.getEmail());
//	if (checkUser == null && checkEmail.size() == 0) {
//		resultado = true;
//	}
//	return resultado;
//	}
//	
//	
//	
//	
//	
//	public boolean checkVerify(String code,User u) {
//		boolean verify=false;
//		if(code.equals(u.getVerificationCode())) {
//			u.setEnabled(true);
//			verify=true;
//		}
//		
//		return verify;
//		
//	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws
	UsernameNotFoundException {
		User user = repository.findById(username).orElse(null);
	if (user == null) {
		throw new UsernameNotFoundException("User not found");
	}
		return user;
	}
	}
	


