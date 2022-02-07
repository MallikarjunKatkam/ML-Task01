//Design a zip lookup service that takes the zip code as an input parameter and returns the corresponding details.
//
//prerequisites:
//1. Create a multi-level class (parent-child), adding attributes(address information) of all types String, int, long, Date
//parent-child relationship like Country -> State -> Area(zip)
//2. In order to do the operation creates two separate classes ZipServicev1(base) and ZipServicev2(child of v1)
//3. Create a main class and do the operation(get, set, print)
//4. Think of using polymorphism, inheritance, abstraction & encapsulation
//5. use the collection as in memory to keep the data
//6. Use loop/iterator to print all record
//7. Use of interface, static method, any validation will be appreciated
package com.bhavna.services;

import java.util.HashMap;
import java.util.Map;

import com.bhavna.model.Area;

public class ZipServiceV2 implements ZipServiceV1 {

	Map<Integer,Area> map=new HashMap<>();
	@Override
	public void addDetails() {
		map.put(505327, new Area("Telangana", "Jagtial", 505327));
		map.put(505328, new Area("Telangana", "Hyderabad", 505328));
		map.put(505329, new Area("Telangana", "Siddipet", 505329));
		map.put(505310, new Area("Telangana", "Nizamabad", 505310));
		map.put(505311, new Area("Telangana", "KarimNagar", 505311));
	}
	@Override
	public void printAllRecords() {			
		for(Area a:map.values()) {
			System.out.println(a);
		}
	}

	@Override
	public void printByZip(int zip) {
		if(map.containsKey(zip))
			System.out.println(map.get(zip));
		else
			System.out.println("No Data Found with the Zip Code: ");
	}
}
