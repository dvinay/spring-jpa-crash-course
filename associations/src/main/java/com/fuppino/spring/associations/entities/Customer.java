package com.fuppino.spring.associations.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private Set<PhoneNumber> numbers; 

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
	
	public Set<PhoneNumber> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<PhoneNumber> numbers) {
		this.numbers = numbers;
	}

	public void addNumber(PhoneNumber number) {
		if(number != null) {
			if(this.numbers == null) {
				numbers = new HashSet<>();
			}
			number.setCustomer(this); //mapping fk
			numbers.add(number);
		}
	}
}
