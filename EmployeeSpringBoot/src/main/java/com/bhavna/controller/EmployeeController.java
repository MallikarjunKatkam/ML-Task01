package com.bhavna.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.model.EmployeeEntity;
import com.bhavna.service.EmployeeServiceI;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeServiceI empService;

	@GetMapping("/getAllEmployees")
	public List<EmployeeEntity> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/getEmployeeById/{id}")
	public Optional<EmployeeEntity> getEmployeeById(@PathVariable Integer id) {
		return empService.getEmployeeById(id);
	}

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return empService.addEmployee(employeeEntity);
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		return empService.deleteEmployee(id);
	}

	@PutMapping("/updateEmployee/{id}")
	public String updateEmployee(@PathVariable Integer id, @RequestBody EmployeeEntity employeeEntity) {
		return empService.updateEmployee(id, employeeEntity);
	}

	@GetMapping("/getAllEmployeesByPage")
	public List<EmployeeEntity> getAllEmployeesByPage(
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
		return empService.getAllEmployeesByPage(page, size);
	}
}
