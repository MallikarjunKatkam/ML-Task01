/*
 Create List of Employees. Employee Class Will have Name, Salary & Location fields.

*.Using Streams find the employee count whose name starts with ""S""
*.Using Parallel Stream Print all the Employees with location ""Hyderabad""
*.Get Location and employees in that location output : Map<String, List<Employees>> 
*	ex : key : "Hyderbad" value : Employees who reside in 	 Hyderabad
*.Using Streams Check if any Employee's Salary is > 100000
* Using Lambds's Write a logic to sort EmployeeList based on Name & location
*/
package com.bhavna.serviceimpli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bhavna.model.EmployeeProps;
import com.bhavna.serviceinter.EmployeeServiceInter;

public class EmployeeServiceImple implements EmployeeServiceInter {

	static List<EmployeeProps> list;
	int count;

	static {
		list = new ArrayList<>();
		list.add(new EmployeeProps("Mallik", 25000.00, "Hyderabad"));
		list.add(new EmployeeProps("Chandu", 38000.00, "Mumbai"));
		list.add(new EmployeeProps("Dinesh", 42000.00, "Chennai"));
		list.add(new EmployeeProps("Balu", 20000.00, "Bangalore"));
		list.add(new EmployeeProps("Hemanth", 70000.00, "Kerala"));
		list.add(new EmployeeProps("Akhil", 30000.00, "Pune"));
		list.add(new EmployeeProps("Eshwar", 50000.00, "Vizag"));
		list.add(new EmployeeProps("Ganesh", 65000.00, "Delhi"));
		list.add(new EmployeeProps("Karthik", 86000.00, "Mumbai"));
		list.add(new EmployeeProps("Suresh", 115000.00, "Vizag"));
		list.add(new EmployeeProps("Imran", 72000.00, "Pune"));
		list.add(new EmployeeProps("Manu", 90000.00, "Delhi"));
		list.add(new EmployeeProps("Shanmuk", 78000.00, "Chennai"));
		list.add(new EmployeeProps("Ram", 100000.00, "Hyderabad"));
		list.add(new EmployeeProps("Lokesh", 89000.00, "Bangalore"));
		list.add(new EmployeeProps("Prashanth", 96000.00, "Hyderabad"));
		list.add(new EmployeeProps("Sridhar", 180000.00, "Delhi"));
	}
//====================================================================================================================		
//	Counting the Number of Employees Starting with S

	@Override
	public void employeeCountNameStartsWithS() {

		list.stream().forEach(t -> {
			if (t.getName().toUpperCase().startsWith("S"))
				count++;
		});
		System.out.println("There are " + count + " Employees Whose Name Starts With \"S\"");
	}

//====================================================================================================================		
//	Getting All the Employees with Location Hyderabad
	@Override
	public void employeesLocationWithHyderabad() {
		System.out.println("Employees Location With Hyderabad: ");
		list.stream().parallel().filter(t -> t.getLocation().contains("Hyderabad") ? true : false)
				.forEach(t -> System.out.println(t));
	}

//====================================================================================================================		
//	Get Location and employees in that location output : Map<String, List<Employees>> 
//		ex : key : "Hyderabad" value : Employees who resides in Hyderabad

	@Override
	public void employeesResidesInLocation() {

		Map<String, List<EmployeeProps>> map = new HashMap<>();
		map = list.stream().collect(Collectors.groupingBy(EmployeeProps::getLocation));
		System.out.println("Employees Grouping By their Locations: ");
		for (Map.Entry<String, List<EmployeeProps>> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
		}
	}

//====================================================================================================================		
//	Using Streams Check if any Employee's Salary is > 100000
	@Override
	public void employeesBasedOnSalaryRange() {
		System.out.println("Employees Whose Salary more than 100000");
		list.stream().filter(t -> t.getSalary() >= 100000 ? true : false).forEach(t -> System.out.println(t));
	}
//====================================================================================================================		
//	 Using Lambds's Write a logic to sort EmployeeList based on Name

	@Override
	public void employeeListBasedOnName() {
		System.out.println("Employees List in Sorting Order Based on their Names: ");
		list.stream().sorted((o1, o2) -> (o1.getName()).compareTo(o2.getName())).forEach(t -> System.out.println(t));
	}

//	 Using Lambds's Write a logic to sort EmployeeList based on Location
	@Override
	public void employeeListBasedOnLocation() {
		System.out.println("Employees List in Sorting Order Based on their Locations: ");
		list.stream().sorted((o1, o2) -> (o1.getLocation()).compareTo(o2.getLocation()))
				.forEach(t -> System.out.println(t));
	}

//====================================================================================================================		
	@Override
	public void optionSelection() {
		try (Scanner scn = new Scanner(System.in)) {
			while (true) {
				System.out.println("Press 1 to Find the Employee Count Whose Name Starts with \"S\": ");
				System.out.println("Press 2 to Print all the Employees with Location Hyderabad: ");
				System.out.println("Press 3 to Get the Location and Employees in that Corresponding Location: ");
				System.out.println("Press 4 to Print all the Employees whose Salary is above 100000: ");
				System.out.println("Press 5 to Print the Employees in Sorting Order Based on Names: ");
				System.out.println("Press 6 to Print the Employees in Sorting Order Based on Location: ");
				System.out.print("Please Enter Your Choice: ");
				int option = scn.nextInt();
				switch (option) {
				case 1:
					employeeCountNameStartsWithS();
					System.out.println();
					break;
				case 2:
					employeesLocationWithHyderabad();
					System.out.println();
					break;
				case 3:
					employeesResidesInLocation();
					System.out.println();
					break;
				case 4:
					employeesBasedOnSalaryRange();
					System.out.println();
					break;
				case 5:
					employeeListBasedOnName();
					System.out.println();
					break;
				case 6:
					employeeListBasedOnLocation();
					System.out.println();
					break;
				default:
					System.out.println("Please Provide a Valid Option: ");
					System.out.println();
				}

				System.out.println();
				System.out.println("Do you want to continue enter Y");
				String str = scn.next();
				if (!str.equalsIgnoreCase("y")) {
					break;
				}
			}
		}
	}
}
