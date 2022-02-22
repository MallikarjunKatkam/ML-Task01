package com.bhavna.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.entity.EmpPojo;
import com.bhavna.exceptions.MyException;
import com.bhavna.repository.EmpRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepository repo;

	@Override
	public List<EmpPojo> getAllActiveEmployees() {
		List<EmpPojo> list = new ArrayList<>();
		list = (List<EmpPojo>) repo.getAllActiveEmployees();
		return list;
	}

	@Override
	public EmpPojo getEmployeeById(int empId) throws MyException {
		if(repo.existsById(empId)) {
			EmpPojo emp = repo.findById(empId).get();
			return emp;
		}
		else {
			System.out.println("No Data Found With the Given ID!");
			throw new MyException("No Data Found With the Given ID! ");
		}
	}
}