package com.bhavna.service;

import java.util.List;
import java.util.Optional;

import com.bhavna.model.EmployeeEntity;

public interface EmployeeServiceI {
	public List<EmployeeEntity> getAllEmployees();

	public String addEmployee(EmployeeEntity employeeEntity);
	
	public Optional<EmployeeEntity> getEmployeeByName(String name);
	
}
