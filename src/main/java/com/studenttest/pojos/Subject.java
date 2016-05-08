package com.studenttest.pojos;

import java.util.Set;

public class Subject {

	private String name;
	private int coursePoints;
	private int sub_id;
	private Set<StudentPojo> student;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}
	
	public Subject(String name, int coursePoints) {
		this.name = name;
		this.coursePoints = coursePoints;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCoursePoints() {
		return coursePoints;
	}
	public void setCoursePoints(int coursePoints) {
		this.coursePoints = coursePoints;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public Set<StudentPojo> getStudent() {
		return student;
	}

	public void setStudent(Set<StudentPojo> studentList1) {
		this.student = studentList1;
	}
}
