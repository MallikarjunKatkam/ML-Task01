/**
 * 
 * "Create Employee,Department tables in DB, Should create the relations PrimaryKey ,foreign key
  with these tables and make sure use data types like bigint,varchar,date/datetime.
 * 1.fetch the data emplyeeid,employee name,employee sal,joining date of emp ,deptid, dept name using jdbc
 * 2.save employee and department tables using jdbc
 * 3.updating the employee table using jdbc
 * 4. write a query for find the number of employees in each department
  whose employee sal  greater than 30000.(fetch coulms dept name,count of emplyee)"
 */
package com.bhavna.empdeptinterface;

public interface EmpDeptServiceInterface {
	public void empTableCreation();
	public void deptTableCreation();
	public void fetchingEmpData();
	public void fetchingDeptData();
	public void insertDataEmp();
	public void insertDataDept();
	public void updateEmp();
	public void updateDept();
	public void employeesCount();
	public void chooseYourOption();
	public void closingJDBCObjects();
}
