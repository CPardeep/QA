package com.qa.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.persistance.domain.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {
	// CRUD Functionality
}
