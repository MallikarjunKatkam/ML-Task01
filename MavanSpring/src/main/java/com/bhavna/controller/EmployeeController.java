package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.EmpPojo;
import com.bhavna.exceptions.MyException;
import com.bhavna.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
    @RequestMapping(value = "/getActiveEmployees", method = RequestMethod.GET  ) 
    public List<EmpPojo> getActiveEmployees() {
        return empService.getAllActiveEmployees();
    }
    
    @RequestMapping(value = "/getEmployeeById/{empId}", method = RequestMethod.GET)
    public EmpPojo getEmployeeById(@PathVariable int empId) throws MyException {
    EmpPojo emp = empService.getEmployeeById(empId);
    return emp;
    }
    
    @RequestMapping(value = "/demo", method = RequestMethod.GET  ) 
    public String getTest() {
        return "Welcome";
    }
}