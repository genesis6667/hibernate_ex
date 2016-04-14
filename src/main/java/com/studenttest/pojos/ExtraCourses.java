package com.studenttest.pojos;

public class ExtraCourses implements Comparable<ExtraCourses> {

	public ExtraCourses() {
		// TODO Auto-generated constructor stub
	}
	
	public ExtraCourses( String courseName) {
		this.courseName = courseName;
	}
	
	private String courseName;
	private int id;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int compareTo(ExtraCourses courses)
	{
		return courseName.compareTo(courses.getCourseName());
	}
}
