package com.qa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.qa.persistance.domain.Cat;
import com.qa.persistance.dto.CatDTO;
import com.qa.persistance.repo.CatRepo;
import com.qa.utils.beanUtils;

@Service
public class CatService {

	private CatRepo repo;

	private ModelMapper mapper;

	// Constructor
	public CatService(CatRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	// This method uses the MethodMapper to convert Cat to a CatDTO:
	public CatDTO mapToDTO(Cat cat) {
		return this.mapper.map(cat, CatDTO.class);
	}

	// Create
	public CatDTO create(Cat cat) {
		// Saves the person to the database
		Cat saved = this.repo.save(cat);
		return this.mapToDTO(saved);
	}

	// ReadAll
	public List<CatDTO> readAll() {
		// Reads all the tuples in database
		List<Cat> catList = this.repo.findAll();
		List<CatDTO> catListDTO = catList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return catListDTO;
	}

	// Read
	public CatDTO read(Long id) {
		// First step is to fetch it from the database which returns returns an Optional
		Cat saved = this.repo.findById(id).orElseThrow();
		// Converts the select cat to dto
		return mapToDTO(saved);
	}

	// Update
	public CatDTO update(Long id, Cat cat) {
		// First step is to fetch it from the database which returns returns an Optional
		Cat x = this.repo.findById(id).orElseThrow();
		beanUtils.mergeNotNull(cat, x);
		Cat updated = this.repo.save(x);
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
