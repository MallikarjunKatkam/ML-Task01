/*"A text file processor, that works on validation(custom exception). 
  That file contains the data in the below format it's basically a user activity feed of the 
  number of times logged in on a particular day.

Tab-separated (a.txt)
Mehneen 01/29 3:00 PM
Rahul   01/29 3:10 PM
Mehneen 01/29 3:25 PM

process this file and put the data in the suitable map-based collection Map< K, List<Object>>. 
Use appropriate key along with remaining information to be kept in the list of custom POJO. 
Finally, return the map of success and failure (suitable reason), considering the failure of one 
shouldn't stop other processing."
*/
package com.bhavna.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.bhavna.exceptions.MyException;
import com.bhavna.file.PersonDetails;
import com.bhavna.model.PersonsLoginData;

public class PersonService implements PersonDetails {

	Map<String, List<PersonsLoginData>> map = new HashMap<>();

	@Override
	public void processingTextFileData() throws MyException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("a.txt"))) {
			String str;
			while ((str = br.readLine()) != null) {
				String[] st = str.split("\\n");
				for (String sr : st) {
					sr = sr.replaceAll("\\s{2,}", "").trim();
					String[] stdate = sr.split("\\s");

					if (map.containsKey(stdate[1])) {
						List<PersonsLoginData> prs = map.get(stdate[1]);
						prs.add(new PersonsLoginData(stdate[0], stdate[1], stdate[2]));
						map.put(stdate[1], prs);
					} else {
						List<PersonsLoginData> prs2 = new ArrayList<>();
						prs2.add(new PersonsLoginData(stdate[0], stdate[1], stdate[2]));
						map.put(stdate[1], prs2);
					}
				}
			}
		}
	}

	@Override
	public void loginDetailsByDate(String date) throws MyException {
		try {
			if (map.containsKey(date)) {
				System.out.println(map.get(date));
			} else {
				throw new MyException(
						"Input Details are Incorrect. Please Pass Correct Details to get loginDetailsByDate: ");
			}
		} catch (MyException me) {
			System.out.println(me.getMessage());
		}
	}

	@Override
	public void loginsCountByDate(String date) throws MyException {
		try {
			if (map.containsKey(date)) {
				System.out.println(map.get(date).size());
			} else {
				throw new MyException(
						"Input Details are Incorrect. Please Pass Correct Details to get loginCountByDate: ");
			}
		} catch (MyException me) {
			System.out.println(me.getMessage());
		}
	}

	@Override
	public void getAllDetails() {
		for (Map.Entry<String, List<PersonsLoginData>> m : map.entrySet()) {
			System.out.println(m.getKey());
			System.out.println("No of Logins in this date: " + m.getValue().size());
			System.out.println(m.getValue());
			System.out.println("\n");
		}
	}

	@Override
	public void optionSelection() throws MyException {
		try (Scanner scn = new Scanner(System.in)) {
			PersonService ps = new PersonService();
			try {
				ps.processingTextFileData();
			} catch (MyException | IOException me) {
				System.out.println(me.getMessage());
			}
			while (true) {
				System.out.println("Please Press 1 to know the count of persons Logged In: ");
				System.out.println("Please Press 2 to Know the Details of the Logged Persons: ");
				System.out.println("Please Press 3 to know all the details of the Persons LoggedIn: ");
				System.out.print("Please Select Your Option: ");
				int option = scn.nextInt();
				String date = "";
				switch (option) {
				case 1:
					System.out.println("Enter the date in MM/DD format");
					date = scn.next();
					try {
						ps.loginsCountByDate(date);
					} catch (MyException me) {
						System.out.println(me.getMessage());
					}
					break;
				case 2:
					System.out.println("Enter the date in MM/DD format");
					date = scn.next();
					try {
						ps.loginDetailsByDate(date);
					} catch (MyException me) {
						System.out.println(me.getMessage());
					}
					break;
				case 3:
					ps.getAllDetails();
					break;
				default:
					throw new MyException("Please Choose Options 1 or 2 or 3:");
				}
				System.out.println();
				System.out.println("Do you want to continue enter Y ");
				String str = scn.next();
				if (!str.equalsIgnoreCase("y")) {
					break;
				}
			}
		} catch (MyException me) {
			System.out.println(me.getMessage());
		}
	}
}
