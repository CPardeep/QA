package com.qa.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;

@Entity
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long ID;

	@Column
	private String name;

	@Column
	private int age;
	
	@ManyToOne(targetEntity = Owner.class)
	private Owner owner = null;

	// Empty constructor
	public Cat() {
		super();
	}
	
	// Part constructor
		public Cat(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

	// Full constructor
	public Cat(Long iD, String name, int age) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
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

}
