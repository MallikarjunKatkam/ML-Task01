/**
 * "Create a CRUD work flow for  a order management system with following features:

 *	1) Place order for any item category ( Take default categories of your choice and save in db). Take apprpropriate fields for 
 *  	Order as deemed necessary.
 *	2) Able to get orders by item category
 *	3) Able to update order by item category. Also implement patch for the same to demonstrate difference between the two
 *	4) Delete the order by item category 
 *	5) Design a global excelption handler for any type of exceptions that can come while performing the above operations"
 * 
 */
package com.bhavna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementSystemApplication.class, args);
	}

}
