package com.bhavna.service;

import org.springframework.stereotype.Service;

import com.bhavna.employee.EmployeeRequest;
import com.bhavna.employee.EmployeeResponse;

@Service
public class EmployeeService {
	public EmployeeResponse salaryIncrement(EmployeeRequest req) {
		EmployeeResponse er=new EmployeeResponse();
		if(req.getDesg().equalsIgnoreCase("manager")) {
			er.setHikePerc(10);
			er.setIsIncreased(true);
			double currentSal=req.getEmpSal();
			double increasedSal=((10.0/100.0)*req.getEmpSal())+currentSal;
			er.setMessage("Congratulations "+req.getEmpName()+". Your Salary Was Increased to "+increasedSal);
		}
	
		if(req.getDesg().equalsIgnoreCase("developer")) {
			er.setHikePerc(5);
			er.setIsIncreased(true);
			er.setMessage("developer");
			double currentSal=req.getEmpSal();
			double increasedSal=((8.0/100.0)*req.getEmpSal())+currentSal;
			er.setMessage("Congratulations "+req.getEmpName()+". Your Salary Was Increased to "+increasedSal);
		}
		if(req.getDesg().equalsIgnoreCase("hr")) {
			er.setHikePerc(6);
			er.setIsIncreased(true);
			er.setMessage("hr");
			double currentSal=req.getEmpSal();
			double increasedSal=((6.0/100.0)*req.getEmpSal())+currentSal;
			er.setMessage("Congratulations "+req.getEmpName()+". Your Salary Was Increased to "+increasedSal);
		}
		if(req.getDesg().equalsIgnoreCase("trainee")) {
			er.setHikePerc(0);
			er.setIsIncreased(false);
			er.setMessage("Your Salary increments will be starts from next year!");
		}
		return er;		
	}
}
