/**
 * 
 * "Create Employee,Department tables in DB, Should create the relations PrimaryKey ,foreign key
  with these tables and make sure use data types like bigint,varchar,date/datetime.
 * 1.fetch the data emplyeeid,employee name,employee sal,joining date of emp ,deptid, dept name using jdbc
 * 2.save employee and department tables using jdbc
 * 3.updating the employee table using jdbc
 * 4. write a query for find the number of employees in each department
  whose employee sal  greater than 30000.(fetch coulms dept name,count of emplyee)"
  
  //SELECT DEPTNAME,COUNT(*) AS NUM FROM DEPT D INNER JOIN EMP E ON E.DEPTID=D.DEPTID WHERE ESAL>=30000 GROUP BY DEPTNAME
 */
package com.bhavna.empdeptimpli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bhavna.empdeptinterface.EmpDeptServiceInterface;

public class EmpDeptServiceImpli implements EmpDeptServiceInterface {
	static String conUrl = null;
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	static Scanner scn = null;
//	=============================================================================================================================
//	Connection Establishing
	static {
		try {
			conUrl = "jdbc:sqlserver://localhost:1433;databaseName=Mallik;user=sa;password=Bhavna@123";
			con = DriverManager.getConnection(conUrl);
			st = con.createStatement();
			scn = new Scanner(System.in);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

//	Emp Table Creation
	@Override
	public void empTableCreation() {
		try {
			String empCreation = "CREATE TABLE EMP(EMPID BIGINT,ENAME VARCHAR(50),ESAL MONEY, DOJ DATE,DEPTID BIGINT FOREIGN KEY REFERENCES DEPT(DEPTID))";
//			String query2="DROP TABLE EMP";
			st.execute(empCreation);
			System.out.println("Employee Table Created Successfully: ");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + ": You Can Access and Perform Operations on the Emp Table");
		}
	}

//	Dept Table Creation
	@Override
	public void deptTableCreation() {
		try {
			String deptCreation = "CREATE TABLE DEPT(DEPTID BIGINT PRIMARY KEY,DEPTNAME VARCHAR(50))";
//			String query1="DROP TABLE DEPT";
			st.execute(deptCreation);
			System.out.println("Department Table Created Successfully: ");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + ": You Can Access and Perform Operations on the Dept Table");
		}
	}

//	=============================================================================================================================
//	Fetching Tables Data
	// Fetching the Emp Table Data:
	@Override
	public void fetchingEmpData() {
		try {
			System.out.println("Fetching the Records From the Emp Table: ");
			System.out.println("==========================================================================");
			System.out.println("Enter the Select Query to Fetch the Employement Table Data");
			scn.nextLine();
			String fetchingEmpDataQuery = scn.nextLine();
//			String fetchingEmpQuery="SELECT * FROM EMP";
			rs = st.executeQuery(fetchingEmpDataQuery); // Executing Select the Query
			System.out.println("EMPID\t\tEMPNAME\t\tEMPSAL\t\tDOJ\t\tDEPTID");
			System.out.println("==========================================================================");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getString(5));
			}
			System.out.println("Records Fetched from the Emp Table! ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===========================================================================");
	}

	// Fetching the Dept Table Data:
	public void fetchingDeptData() {
		try {
			System.out.println("Fetching the Records From the Dept Table: ");
			System.out.println("===========================================================================");
			System.out.println("Enter the Select Query to Fetch the Department Table Data");
			scn.nextLine();
			String fetchingDeptDataQuery = scn.nextLine();
//			String fetchingDeptDataQuery="SELECT * FROM DEPT";
			rs = st.executeQuery(fetchingDeptDataQuery); // Executing Select the Query
			System.out.println("DEPTID\t" + "DEPTNAME\t");
			System.out.println("===================");
			while (rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2));
			}
			System.out.println("Records Fetched from the Dept Table! ");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===========================================================================");
	}
//	=============================================================================================================================

//	Inserting Data into Emp Table
	@Override
	public void insertEmpData() {
		try {
			System.out.println("Inserting the Records into Emp Table: ");
			System.out.println("===========================================================================");
			System.out.print("Enter empId: ");
			int empId = scn.nextInt();
			scn.nextLine();
			System.out.print("Enter empName: ");
			String empName = scn.nextLine();
			System.out.print("Enter empSalary: ");
			double sal = scn.nextDouble();
			scn.nextLine();
			System.out.print("Enter empDateOfJoining: ");
			String date = scn.nextLine();
			System.out.print("Enter deptId: ");
			int deptId = scn.nextInt();
			String insertQuery = "INSERT INTO EMP VALUES(" + empId + ",\'" + empName + "\'," + sal + ",\'" + date
					+ "\'," + deptId + ")";
			st.executeUpdate(insertQuery);
			System.out.println("Record was inserted successfully! ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===========================================================================");
	}

//	Inserting Data into Dept Table
	@Override
	public void insertDeptData() {
		try {
			System.out.println("Inserting the Records into Dept Table: ");
			System.out.println("===========================================================================");
			System.out.print("Enter deptId: ");
			int deptId = scn.nextInt();
			scn.nextLine();
			System.out.print("Enter deptName: ");
			String deptName = scn.nextLine();

			String insertQuery = "INSERT INTO DEPT VALUES(" + deptId + ",\'" + deptName + "\')";
			st.executeUpdate(insertQuery);
			System.out.println("Record was inserted successfully! ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===========================================================================");
	}

//	Updating Emp Table Data
	@Override
	public void updateEmp() {
		try {
			System.out.println("Updating the Records in the Emp Table: ");
			System.out.println("===========================================================================");
//			String updateQuery="UPDATE EMP SET ENAME=\'Mallik\' WHERE EMPID=101";
			System.out.println("Enter Your Query to Update the Emp Table Records: ");
			scn.nextLine();
			String updateQuery = scn.nextLine();
			st.executeUpdate(updateQuery);
			System.out.println("One Record is Updated Successfully in Emp Table! ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===========================================================================");
	}

//	Updating Dept Table Data
	@Override
	public void updateDept() {
		try {
			System.out.println("Updating the Records in the Dept Table: ");
			System.out.println("===========================================================================");
//			String updateQuery="UPDATE DEPT SET DEPTNAME=\'Dev\' WHERE DEPTID=40";
			System.out.println("Enter Your Query to Update the Dept Table Records: ");
			scn.nextLine();
			String updateQuery = scn.nextLine();
			st.executeUpdate(updateQuery);
			System.out.println("One Record is Updated Successfully in Dept Table! ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===========================================================================");
	}

//	Counting Number of Employees group by DepartmentName and Greater Than 30000 Salary
	public void employeesCount() {
		try {
			System.out.println("Counting Number of Employees Group by Department Name and Greater Than 30000 Salary: ");
			System.out.println("===========================================================================");
			String query = "SELECT DEPTNAME,COUNT(*) AS NUM FROM DEPT D INNER JOIN EMP E ON E.DEPTID=D.DEPTID WHERE ESAL>=30000 GROUP BY DEPTNAME";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString(1) + " Department Have " + rs.getString(2) + " Employees: ");
			}
			System.out.println("Executed Successfully! ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("===========================================================================");
	}

//	Closing JDBC Objects
	@Override
	public void closingJDBCObjects() {
		try {
			if (scn != null)
				scn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void chooseYourOption() {
		try {
			while (true) {
				System.out.println("Press 1 to Create the Dept Table in the Database: ");
				System.out.println("Press 2 to Create the Emp Table in the Database: ");
				System.out.println("Press 3 to Fetch the Data From Emp Table: ");
				System.out.println("Press 4 to Fetch the Data From Dept Table: ");
				System.out.println("Press 5 to Insert the Data into Emp Table: ");
				System.out.println("Press 6 to Insert the Data into Dept Table: ");
				System.out.println("Press 7 to Update the Data in the Emp Table: ");
				System.out.println("Press 8 to Update the Data in the Dept Table: ");
				System.out.println(
						"Press 9 to Count the Number of Employees Group by Department Name and Greater Than 30000 Salary:");
				System.out.println("Please Enter Your Choice: ");
				int option = scn.nextInt();
				switch (option) {
				case 1:
					deptTableCreation();
					System.out.println();
					break;
				case 2:
					empTableCreation();
					System.out.println();
					break;
				case 3:
					fetchingEmpData();
					System.out.println();
					break;
				case 4:
					fetchingDeptData();
					System.out.println();
					break;
				case 5:
					insertEmpData();
					System.out.println();
					break;
				case 6:
					insertDeptData();
					System.out.println();
					break;
				case 7:
					updateEmp();
					System.out.println();
					break;
				case 8:
					updateDept();
					System.out.println();
					break;
				case 9:
					employeesCount();
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
					System.out.println("You Can Exit Now! ");
					break;
				}
			}
		}finally {
			closingJDBCObjects();
		}
	}
//	=============================================================================================================================
}
