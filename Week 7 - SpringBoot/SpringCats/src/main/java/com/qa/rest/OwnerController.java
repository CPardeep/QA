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

import com.qa.persistance.domain.Owner;
import com.qa.persistance.dto.OwnerDTO;
import com.qa.services.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	private OwnerService service;

	public OwnerController(OwnerService service) {
		super();
		this.service = service;
	}

	// Post
	@PostMapping("/create")
	public ResponseEntity<OwnerDTO> create(@RequestBody Owner owner) {
		return new ResponseEntity<OwnerDTO>(this.service.create(owner), HttpStatus.CREATED);
	}

	// GetAll
	@GetMapping("/readAll")
	public ResponseEntity<List<OwnerDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	// Get
	@GetMapping("/read/{id}")
	public ResponseEntity<OwnerDTO> read(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.read(id));
	}

	// Put
	@PutMapping("/update/{id}")
	public ResponseEntity<OwnerDTO> update(@PathVariable("id") Long id, @RequestBody Owner owner) {
		return new ResponseEntity<OwnerDTO>(this.service.update(id, owner), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		// Remove Person and return it
		return this.service.delete(id);
	}

}
