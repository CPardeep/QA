package com.qa.testService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.SpringCatsApplication;
import com.qa.persistance.domain.Cat;
import com.qa.persistance.dto.CatDTO;
import com.qa.persistance.repo.CatRepo;
import com.qa.services.CatService;

@SpringBootTest(classes = SpringCatsApplication.class)
class CatServiceTest {

	// @InjectMocks
	@Autowired
	private CatService service;

	// @Mocks
	@MockBean
	private CatRepo repo;

	// create
	public void constructor() {

	}

	@Test
	// create
	public void create() {
		// Setup
		Cat testCat = new Cat("gg", 1);
		testCat.setID(1L);

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.save(testCat)).thenReturn(testCat);

		// Action --> this is the part of the method you want to test
		// Assertion --> this is where you check what the method returns is equal to
		// what is expected.
		Assertions.assertThat(this.service.create(testCat)).isEqualTo(new CatDTO(1L, "gg", 1));

		// Verify --> this is done to see how many times a method spits out stuff
		Mockito.verify(this.repo, Mockito.times(1)).save(testCat);
	}

	@Test
	// readAll
	public void readAll() {

		// Setup
		List<Cat> TEST_CATLIST = new ArrayList<Cat>();
		TEST_CATLIST.add(new Cat(1L, "gg", 1));

		List<CatDTO> TEST_CATDTOLIST = new ArrayList<CatDTO>();
		TEST_CATDTOLIST.add(new CatDTO(1L, "gg", 1));

		// Rules --> this is used when it is deffered to another class
		Mockito.when(this.repo.findAll()).thenReturn(TEST_CATLIST);

		// Action --> this is the part of the method you want to test
		// Assertion --> this is where you check what the method returns is equal to
		// what is expected.
		Assertions.assertThat(this.service.readAll()).isEqualTo(TEST_CATDTOLIST);

		// Verify --> this is done to check how many times the method is called.
		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

//	@Test
//	// read
//	public void read() {
//		// Setup
//		Cat TESTCAT = new Cat(1L, "gg", 1);
//
//		// Rules --> this is used when it is deffered to another class
//		Mockito.when(this.repo.findById(1L))).thenReturn(Optional.of(1));
//
//		// Action --> this is the part of the method you want to test
//		// Assertion --> this is where you check what the method returns is equal to
//		// what is expected.
//		Assertions.assertThat(this.service.read(TESTCAT.getID())).isEqualTo(new CatDTO(1L, "gg", 1));
//
//		// Verify --> this is done to see how many times a method spits out stuff
//		Mockito.verify(this.repo, Mockito.times(1)).findById(TESTCAT.getID()).orElseThrow();
//	}

	@Test
	// update
	public void update() {

	}

	@Test
	// Delete
	public void delete() {

	}

}
