package com.example.restdemo.web;

import com.example.restdemo.models.DTO.EmployeeDTO;
import com.example.restdemo.models.Employee;
import com.example.restdemo.response.ResponseHandler;
import com.example.restdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/restAPI")
public class RestController {
	private final EmployeeService employeeService;
	@Autowired
	public RestController(EmployeeService employeeService) {this.employeeService = employeeService;}
	//Custom Response
	@GetMapping("{employeeId}")
	public ResponseEntity<Object> getEmployeeDetails(@PathVariable("employeeId") Long employeeId){
		return ResponseHandler.responseBuilder("Request details given here",
				HttpStatus.OK,
				employeeService.getEmployee(employeeId));
	}
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployeeDetails(){
		return ResponseEntity.ok().body(employeeService.getAllEmployees());
	}
	@PostMapping
	public String createEmployee(@RequestBody EmployeeDTO employeeDTO){
		employeeService.createEmployee(employeeDTO);
		return "success message";
	}
	@PutMapping
	public String updateEmployee(@RequestBody EmployeeDTO employeeDTO){
		employeeService.updateEmployee(employeeDTO);
		return "update successful";
	}
	@DeleteMapping("{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Long id){
		employeeService.deleteEmployee(id);
		return "deleted";
	}
}
