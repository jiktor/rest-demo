package com.example.restdemo.models;

import jakarta.persistence.*;



@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column
	private PositionEnum position;

	public Employee(Long id, String name, PositionEnum position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}

	public PositionEnum getPosition() {
		return position;
	}

	public Employee setPosition(PositionEnum position) {
		this.position = position;
		return this;
	}

	public Employee(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee() {
	}

	public Long getId() {
		return id;
	}

	public Employee setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}
}
