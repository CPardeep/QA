package com.qa.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.persistance.domain.Owner;
import com.qa.persistance.dto.OwnerDTO;
import com.qa.persistance.repo.OwnerRepo;

@Service
public class OwnerService {

	private OwnerRepo repo;

	private ModelMapper mapper;

	// Constructor
	public OwnerService(OwnerRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	// This method uses the MethodMapper to convert a Owner to a OwnerDTO
	private OwnerDTO mapToDTO(Owner owner) {
		return this.mapper.map(owner, OwnerDTO.class);
	}

	// Create
	public OwnerDTO create(Owner owner) {
		// Saves the person to the database
		Owner saved = this.repo.save(owner);
		return this.mapToDTO(saved);
	}

	// ReadAll
	public List<OwnerDTO> readAll() {
		// Reads all the tuples in database
		List<Owner> ownerList = this.repo.findAll();
		List<OwnerDTO> ownerListDTO = ownerList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return ownerListDTO;
	}

	// Read
	public OwnerDTO read(Long id) {
		// First step is to fetch it from the database which returns returns an Optional
		 Owner saved = this.repo.findById(id).orElseThrow();
		// To get the actual object we will need to extract it
		 return mapToDTO(saved);
	}

	// Update
	public OwnerDTO update(Long id, Owner owner) {
		// First step is to fetch it from the database which returns returns an Optional
		Optional<Owner> existingOptional = this.repo.findById(id);
		// To get the actual object we will need to extract it
		Owner existing = existingOptional.get();
		// Then we can set update with new values
		existing.setDOB(owner.getDOB());
		existing.setName(owner.getName());
		Owner updated = this.repo.save(existing);
		return mapToDTO(updated);
	}

	// Delete
	public boolean delete(Long id) {
		// removes the entity
		this.repo.deleteById(id);
		// checks to see if it still exists
		boolean exists = this.repo.existsById(id);
		// returns true if entity no longer exists
		return !exists;
	}

}
