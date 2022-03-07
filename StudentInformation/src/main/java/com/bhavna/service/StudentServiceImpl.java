package com.bhavna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bhavna.dao.StudentDAO;
import com.bhavna.model.CourseEntity;
import com.bhavna.model.StudentEntity;

@Transactional
@Service
public class StudentServiceImpl implements StudentServiceI {
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<CourseEntity> getStudents() {
		return studentDAO.getStudents();
	}
	
	@Override	   
    public void addStudent(StudentEntity student) {
    	studentDAO.addStudent(student);
    }

    @Override
    public StudentEntity getStudentById(Integer id) {
        return studentDAO.getStudentById(id);
    }

	@Override
	public void updateStudentById(Integer studentId, StudentEntity student) {
	  studentDAO.updateStudent(studentId,student);
	}
}
/**CREATE TABLE BANK (PK_BANK_ID INT PRIMARY KEY,
BANKNAME VARCHAR(50),
BRANCH VARCHAR(50),
ADDRES VARCHAR(50))


CREATE TABLE CUSTOMERS (PK_CUSTOMERS_ID INT PRIMARY KEY,
CUSTNAME VARCHAR(50),
ACCOUNTNO BIGINT,
BRANCH VARCHAR(50),
ADDRES VARCHAR(50),
PK_BANK_ID INT FOREIGN KEY REFERENCES BANK(PK_BANK_ID));




 */
