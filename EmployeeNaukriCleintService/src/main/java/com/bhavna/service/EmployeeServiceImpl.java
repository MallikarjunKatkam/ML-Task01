package com.bhavna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.model.EmployeeEntity;
import com.bhavna.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	EmployeeRepository empRepository;
	
	@Override
	public String addEmployee(EmployeeEntity employeeEntity) {
		empRepository.save(employeeEntity);
		return "Employee Was Added Successfully!"; 
	}

	@Override
	public Optional<EmployeeEntity> getEmployeeByName(String name) {
		return empRepository.findById(name);
	}
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return empRepository.findAll();
	}
}
