package com.qa.persistance.dto;

import com.qa.persistance.domain.Owner;

public class CatDTO {
	private Long ID;
	private String name;
	private int age;
	//private Owner owner;

	public CatDTO() {
		super();
	}

	public CatDTO(Long iD, String name, int age) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "CatDTO [ID=" + ID + ", name=" + name + ", age=" + age + "]";
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
