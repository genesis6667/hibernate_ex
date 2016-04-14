package com.studenttest.pojos;

import java.util.HashSet;

public class College {

	private String name;
	private int id;
	private HashSet<StudentPojo> students = new HashSet<StudentPojo>();
	
	public College(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HashSet<StudentPojo> getStudents() {
		return students;
	}

	public void setStudents(HashSet<StudentPojo> students) {
		this.students = students;
	}

}
