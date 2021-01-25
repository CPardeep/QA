package com.qa.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistance.domain.Cat;
import com.qa.persistance.dto.CatDTO;
import com.qa.services.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {

	private CatService service;

	public CatController(CatService service) {
		super();
		this.service = service;
	}

	// Post
	@PostMapping("/create")
	public ResponseEntity<CatDTO> create(@RequestBody Cat cat) {
		return new ResponseEntity<CatDTO>(this.service.create(cat), HttpStatus.CREATED);
	}

	// GetAll
	@GetMapping("/readAll")
	public ResponseEntity<List<CatDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// Get
	@GetMapping("/read/{id}")
	public ResponseEntity<CatDTO> read(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.read(id));
	}

	// Put
	@PutMapping("/update/{id}")
	public ResponseEntity<CatDTO> update(@PathVariable("id") Long id, @RequestBody Cat cat) {
		return new ResponseEntity<CatDTO>(this.service.update(id, cat), HttpStatus.OK);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		// Remove Person and return it
		return this.service.delete(id);
	}

}
