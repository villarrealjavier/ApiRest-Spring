package com.jacaranda.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.demo.model.element;



public interface elementRepository extends JpaRepository<element, Integer> {
	public Page<element> findByNameLike(String keyword,
			Pageable pageable);
}