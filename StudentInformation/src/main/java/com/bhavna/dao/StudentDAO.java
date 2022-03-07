package com.bhavna.dao;

import java.util.List;

import com.bhavna.model.CourseEntity;
import com.bhavna.model.StudentEntity;

public interface StudentDAO {
	public List<CourseEntity> getStudents();

	public void addStudent(StudentEntity student);

	public StudentEntity getStudentById(Integer id);

	public void updateStudent(Integer studentId, StudentEntity student);
}
