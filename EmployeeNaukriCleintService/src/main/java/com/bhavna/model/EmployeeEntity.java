package com.bhavna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Table")
public class EmployeeEntity {
	
	@Column(name = "EMP_ID")
	private Integer empId;

	@Id
	@Column(name="EMP_NAME", unique = true)
	private String empName;
	
	@Column(name="EMP_AGE")
	private Integer emp_Age;
	
	@Column(name="EMP_SALARY")
	private Double empSalary;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="GENDER")
	private String emp_Gender;

	public EmployeeEntity() {
	}

	public EmployeeEntity(Integer empId, String empName, Integer emp_Age, Double empSalary, String jobTitle,
			String emp_Gender) {
		this.empId = empId;
		this.empName = empName;
		this.emp_Age = emp_Age;
		this.empSalary = empSalary;
		this.jobTitle = jobTitle;
		this.emp_Gender = emp_Gender;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmp_Age() {
		return emp_Age;
	}

	public void setEmp_Age(Integer emp_Age) {
		this.emp_Age = emp_Age;
	}

	public Double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Double empSalary) {
		this.empSalary = empSalary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEmp_Gender() {
		return emp_Gender;
	}

	public void setEmp_Gender(String emp_Gender) {
		this.emp_Gender = emp_Gender;
	}

	@Override
	public String toString() {
		return "EmployeeEntity (" + empId + ", " + empName + ", " + emp_Age + ", " + empSalary + ", " + jobTitle + ", "
				+ emp_Gender + ")";
	}
}
