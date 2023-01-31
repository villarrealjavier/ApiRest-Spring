package com.jacaranda.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.demo.model.element;
import com.jacaranda.demo.services.ElementServices;

@RestController
public class ElementController {
	
	@Autowired
	ElementServices services;
	
	@GetMapping("/element")
	public List<element> getElements() {

		return services.getElements();
	}

	
	@GetMapping("/element/{id}")
	public element getElement(@PathVariable Integer id) {
		return services.getElement(id);
	}
	
	@PutMapping("/element/{id}")
	public ResponseEntity<?> edit(@RequestBody element elemento,
			@PathVariable Integer id) {
		if(services.getElement(id)!=null) {
			elemento.setId(id);
			services.save(elemento);
			return ResponseEntity.ok(elemento);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/element")
	public ResponseEntity<?> add(@RequestBody element elemento) {
		if(services.getElement(elemento.getId())==null) {
			services.save(elemento);
			return ResponseEntity.ok(elemento);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/element/{id}")
	public ResponseEntity<?>  delete(@PathVariable Integer id) {
		if(services.getElement(id)!=null) {
			element e = services.getElement(id);
			services.delete(e);
			return ResponseEntity.ok("Element deleted");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
