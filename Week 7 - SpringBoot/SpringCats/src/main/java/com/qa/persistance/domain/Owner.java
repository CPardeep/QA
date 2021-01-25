package com.qa.persistance.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column
	private String DOB;

	@OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Cat> catList;

	// Empty constructor
	public Owner() {
		super();
	}

	// Full constructor
	public Owner(Long id, String name, String dOB, List<Cat> catList) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
		this.catList = catList;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", DOB=" + DOB + "]";
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
		this.DOB = dOB;
	}
	
	public List<Cat> getCatList() {
		return catList;
	}

	public void setCatList(List<Cat> catList) {
		this.catList = catList;
	}


}
