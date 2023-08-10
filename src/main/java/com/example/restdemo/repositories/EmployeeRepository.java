package com.example.restdemo.repositories;

import com.example.restdemo.models.Employee;
import com.example.restdemo.models.PositionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	public List<Employee> findByPosition(PositionEnum positionEnum);
}
