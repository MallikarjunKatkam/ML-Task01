/*
 Create List of Employees. Employee Class Will have Name, Salary & Location fields.

*.Using Streams find the employee count whose name starts with ""S""
*.Using Parallel Stream Print all the Employees with location ""Hyderabad""
*.Get Location and employees in that location output : Map<String, List<Employees>> ex : key : "Hyderbad" value : Employees who reside in 	 Hyderabad
*.Using Streams Check if any Employee's Salary is > 100000
* Using Lambds's Write a logic to sort EmployeeList based on Name & location
*/
package com.bhavna.serviceinter;

public interface EmployeeServiceInter {

	public void employeeCountNameStartsWithS();
	
	public void employeesLocationWithHyderabad();
	
	public void employeesResidesInLocation();
	
	public void employeesBasedOnSalaryRange();
	
	public void employeeListBasedOnName();
	
	public void employeeListBasedOnLocation();	
	
	public void optionSelection();
}
