package com.example.restdemo.models.DTO;

import com.example.restdemo.models.PositionEnum;

public class EmployeeDTO {
	private Long id;
	private String name;
	private PositionEnum position;

	public Long getId() {
		return id;
	}

	public EmployeeDTO setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public EmployeeDTO setName(String name) {
		this.name = name;
		return this;
	}

	public PositionEnum getPosition() {
		return position;
	}

	public EmployeeDTO setPosition(PositionEnum position) {
		this.position = position;
		return this;
	}

	public EmployeeDTO() {
	}

	public EmployeeDTO(String name, PositionEnum position) {
		this.name = name;
		this.position = position;
	}

	public EmployeeDTO(Long id, String name, PositionEnum position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}
}
