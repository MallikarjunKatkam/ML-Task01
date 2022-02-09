/*
 Create List of Employees. Employee Class Will have Name, Salary & Location fields.

*.Using Streams find the employee count whose name starts with ""S""
*.Using Parallel Stream Print all the Employees with location ""Hyderabad""
*.Get Location and employees in that location output : Map<String, List<Employees>> ex : key : "Hyderbad" value : Employees who reside in 	 Hyderabad
*.Using Streams Check if any Employee's Salary is > 100000
* Using Lambds's Write a logic to sort EmployeeList based on Name & location
*/
package com.bhavna.model;

public class EmployeeProps {
	private String name;
	private double salary;
	private String location;

	public EmployeeProps() {

	}

	public EmployeeProps(String name, double salary, String location) {
		super();
		this.name = name;
		this.salary = salary;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "EmployeeProps (" + name + ", " + salary + ", " + location + ")";
	}

}
