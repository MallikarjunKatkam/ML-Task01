package com.bhavna.model;
public class EmpDeptData {
	private int empId;
	private String empName;
	private double empSal;
	private String doj;
	private int deptId;
	
	private String deptName;
	public EmpDeptData() {
	}
	public EmpDeptData(int empId, String empName, double empSal, String doj, int deptId,String deptName) {
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.doj = doj;
		this.deptId = deptId;
		this.deptName=deptName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
