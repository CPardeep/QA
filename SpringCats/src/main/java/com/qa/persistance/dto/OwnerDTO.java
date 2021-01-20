package com.qa.persistance.dto;

import java.util.List;

public class OwnerDTO {

	private Long id;
	private String name;
	private String DOB;
	private List<CatDTO> catList;

	public OwnerDTO() {
		super();
	}

	public OwnerDTO(Long id, String name, String dOB, List<CatDTO> catList) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
		this.catList = catList;
	}

	@Override
	public String toString() {
		return "OwnerDTO [id=" + id + ", name=" + name + ", DOB=" + DOB + ", catList=" + catList + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public List<CatDTO> getCatList() {
		return catList;
	}

	public void setCatList(List<CatDTO> catList) {
		this.catList = catList;
	}

}
