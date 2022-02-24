package com.bhavna.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bhavna.employee.EmployeeRequest;
import com.bhavna.employee.EmployeeResponse;
import com.bhavna.service.EmployeeService;

@Endpoint
public class EmployeeEndpoint {
	private static final String NAMESPACE = "http://www.bhavna.com/employee";
	@Autowired
	private EmployeeService service;

	@PayloadRoot(namespace = NAMESPACE, localPart = "EmployeeRequest")
	@ResponsePayload
	public EmployeeResponse getLoanStatus(@RequestPayload EmployeeRequest request) {
		return service.salaryIncrement(request);
	}
}