package com.fuppino.spring.associations.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="projects")
	private Set<Programmer> Programmer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Programmer> getProgrammer() {
		return Programmer;
	}
	public void setProgrammer(Set<Programmer> programmer) {
		Programmer = programmer;
	}
	
	
}
