package com.example.restdemo.service;

import com.example.restdemo.models.DTO.EmployeeDTO;
import com.example.restdemo.models.Employee;

import java.util.List;

public interface EmployeeService {
	public String createEmployee(EmployeeDTO employeeDTO);
	public String updateEmployee(EmployeeDTO employeeDTO);
	public String deleteEmployee(Long employee);
	public EmployeeDTO getEmployee(Long employeeId);
	public List<EmployeeDTO> getAllEmployees();
}
