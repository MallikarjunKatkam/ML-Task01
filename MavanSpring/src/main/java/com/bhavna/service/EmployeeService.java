package com.bhavna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhavna.entity.EmpPojo;
import com.bhavna.exceptions.MyException;

@Service
public interface EmployeeService {

	public List<EmpPojo> getAllActiveEmployees();
	
	public EmpPojo getEmployeeById(int empId) throws MyException;
}