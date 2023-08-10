package com.example.restdemo.service.Impl;

import com.example.restdemo.exception.EmployeeNotFoundException;
import com.example.restdemo.models.DTO.EmployeeDTO;
import com.example.restdemo.models.Employee;
import com.example.restdemo.repositories.EmployeeRepository;
import com.example.restdemo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
		this.employeeRepository = employeeRepository;
		this.modelMapper = modelMapper;
	}
	@Override
	public String createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO,Employee.class);
		employeeRepository.save(employee);
		return "success";
	}

	@Override
	public String updateEmployee(EmployeeDTO employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO,Employee.class);
		employeeRepository.save(employee);
		return "success";
	}

	@Override
	public String deleteEmployee(Long employee) {
		employeeRepository.deleteById(employee);
		return "success";
	}

	@Override
	public EmployeeDTO getEmployee(Long employeeId) {
		if(employeeRepository.findById(employeeId).isEmpty()){
			throw new EmployeeNotFoundException("Requested user doesn't exist");
		}
		return modelMapper.map(employeeRepository.findById(employeeId).get(),EmployeeDTO.class);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> list = employeeRepository.findAll();
		List<EmployeeDTO> dtoList = new ArrayList<>();
		for(Employee employee : list){
			dtoList.add(modelMapper.map(employee,EmployeeDTO.class));
		}
		return dtoList;
	}
}
