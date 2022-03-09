/**
 * "Create A Spring Boot Application, Use DB any of your choice
DB will Have Employe Table with columns: id, Name, Age, Salary, Job Title, Gender

Expose the below end points 

* POST /api/Employee : To Save an Employee Details
* GET /api/Employee/{id} : To retrie the Specific Employee Details with the id
* PUT /api/Employee : To Update the Employee Details
* DELETE /api/Employee/{id} : Will Delete the specific Employee with the id
* GET /api/Employees?page=1&size=10 : Use Spring JPA Pagination concept here 
The Specified URl will fetch First 10 records, and if page=2&size=10 it will fectch Records 11-20 in the DB"*/
package com.bhavna.service;

import java.util.List;
import java.util.Optional;

import com.bhavna.model.EmployeeEntity;

public interface EmployeeServiceI {
	public String addEmployee(EmployeeEntity employeeEntity);
	
	public Optional<EmployeeEntity> getEmployeeById(Integer id);
	
	public String updateEmployee(Integer id, EmployeeEntity employeeEntity);
	
	public String deleteEmployee(Integer id);

	public List<EmployeeEntity> getAllEmployees();

	public List<EmployeeEntity> getAllEmployeesByPage(Integer offset, Integer size);
}
