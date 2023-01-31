package com.jacaranda.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.demo.model.element;
import com.jacaranda.demo.repository.elementRepository;

@Service
public class ElementServices {

	@Autowired
	elementRepository repository;
	
	public List<element> getElements(){
		return repository.findAll();
	}
	
	public element getElement(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public element save(element e) {
		return repository.save(e);
	}

	public void delete(element e) {
		repository.delete(e);
	}
	
}
