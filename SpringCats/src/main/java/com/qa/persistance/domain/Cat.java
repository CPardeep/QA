package com.qa.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column
	private String name;

	@Column
	private int age;
	
	@ManyToOne
	private Owner owner;

	// Empty constructor
	public Cat() {
		super();
	}

	// Full constructor
	public Cat(Long iD, String name, int age, Owner owner) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Cat [ID=" + ID + ", name=" + name + ", age=" + age + "]";
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	

}
