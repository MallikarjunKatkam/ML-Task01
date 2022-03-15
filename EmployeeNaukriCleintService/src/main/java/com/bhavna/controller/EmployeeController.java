package com.bhavna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.EmployeeEntity;
import com.bhavna.service.EmployeeServiceI;

@RefreshScope
@RestController
public class EmployeeController {
	@Autowired
	EmployeeServiceI empService;
	
	@Value("${domain}")
	private String message;
	
	@GetMapping("/message")
	public String getMessage() {
		return message;
	}

	@GetMapping("/getAllEmployees")
	public List<EmployeeEntity> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@GetMapping("/getEmployee/{name}" + "${domain}")
	public Optional<EmployeeEntity> getEmployeeByName(@PathVariable("name") String name) {
		return empService.getEmployeeByName(name);
	}

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return empService.addEmployee(employeeEntity);
	}

}
