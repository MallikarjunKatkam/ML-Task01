package com.bhavna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Optional<EmployeeEntity> getEmployeeById(Integer id) {
		return empRepository.findById(id);
	}

	@Override
	public String updateEmployee(Integer id, EmployeeEntity employeeEntity) {
		if(empRepository.existsById(id)) {
			empRepository.save(employeeEntity);
			return "Employee Details was Changed! ";
		}
		else {
			return "Employee Data is not Available with the given Id! ";
		}
	}

	@Override
	public String deleteEmployee(Integer id) {
		if(empRepository.existsById(id)) {
			empRepository.deleteById(id);
			return "Employee Data Was Deleted Successfully! ";
		}
		else {
			return "Employee Data is not Available with the given Id! ";
		}
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return empRepository.findAll();
	}
	
	@Override
	public List<EmployeeEntity> getAllEmployeesByPage(Integer offset, Integer size) {
		Pageable pageable = PageRequest.of(offset, size);
		return empRepository.findAll(pageable).toList();
	}
}
