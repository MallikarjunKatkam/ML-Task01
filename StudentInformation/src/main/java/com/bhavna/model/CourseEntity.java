package com.bhavna.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Courses")
public class CourseEntity {
	
	@Id
	@Column(name="course_id")
	private Integer courseid;
	
	@Column(name="course")
	private String course;
	
	@Column(name="institute")
	private String institue;
	
	@Column(name="institute_address")
	private String institute_address;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<StudentEntity> student;
	
	public CourseEntity() {
	}

	public CourseEntity(Integer courseid, String course, String institue, String institute_address) {
		super();
		this.courseid = courseid;
		this.course = course;
		this.institue = institue;
		this.institute_address = institute_address;
	}

	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getInstitue() {
		return institue;
	}

	public void setInstitue(String institue) {
		this.institue = institue;
	}

	public String getInstitute_address() {
		return institute_address;
	}

	public void setInstitute_address(String institute_address) {
		this.institute_address = institute_address;
	}
	
	public List<StudentEntity> getStudent() {
		return student;
	}

	public void setStudent(List<StudentEntity> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "CourseEntity (" + courseid + ", " + course + ", " + institue + ", " + institute_address + ")";
	}
}
