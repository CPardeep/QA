package com.qa.testRest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.SpringCatsApplication;
import com.qa.persistance.domain.Cat;
import com.qa.persistance.dto.CatDTO;

@SpringBootTest(classes = SpringCatsApplication.class)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema.sql", "classpath:data_e.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")

public class CatControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper jsonifier;

	private final Long test_id = 1L;
	private Cat testCat = new Cat(1L, "gg", 2);
	private Cat testCat2 = new Cat(1L, "aa", 1);

	// Tests

	// Create
	@Test
	public void createCat() throws Exception {
		// Prepare Test
		Cat testCat = new Cat(3L, "gg", 2);
		CatDTO testCatSTO = new CatDTO(3L, "gg", 2);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/cat/create")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.jsonifier.writeValueAsString(testCat));

		// Assertion Check
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(testCatSTO));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);

	}

	// Read
	@Test
	public void readCat() throws Exception {

		// Prepare Test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/cat/read/" + 2L)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		// Assertion CHeck
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(new CatDTO(2L, "cc", 1)));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	// ReadAll
	@Test
	public void readAllCat() throws Exception {
		// Prepare Test
		List<CatDTO> catDTOList = new ArrayList<>();
		catDTOList.add(new CatDTO(1L, "gg", 2));
		catDTOList.add(new CatDTO(2L, "cc", 1));

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/cat/readAll")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		// Assertion CHeck
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(catDTOList));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	// Update
	@Test
	public void updateCat() throws Exception{
		// Prepare Test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "/cat/update/" + 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.jsonifier.writeValueAsString(testCat2));

		// Assertion Check
		ResultMatcher matchContent = MockMvcResultMatchers.content()
				.json(this.jsonifier.writeValueAsString(new CatDTO(1L, "aa", 1)));
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchContent);
	}

	// Delete
	@Test
	public void deleteCat() throws Exception {
		// Prepare Test
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/cat/delete/" + 1);

		// Assertion CHeck
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();

		// Perform
		this.mock.perform(mockRequest).andExpect(matchStatus);
	}

}
