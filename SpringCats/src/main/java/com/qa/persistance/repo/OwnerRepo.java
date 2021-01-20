package com.qa.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.persistance.domain.Owner;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Long> {
	// CRUD Functionality
}
