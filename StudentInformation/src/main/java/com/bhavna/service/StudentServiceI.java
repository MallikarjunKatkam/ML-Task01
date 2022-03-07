package com.bhavna.service;

import java.util.List;

import com.bhavna.model.CourseEntity;
import com.bhavna.model.StudentEntity;

public interface StudentServiceI {
	public List<CourseEntity> getStudents();

	public void addStudent(StudentEntity student);

	public StudentEntity getStudentById(Integer id);

	public void updateStudentById(Integer studentId, StudentEntity student);
}
