package com.studenttest.pojos;

import java.util.Set;
import java.util.SortedSet;

public class StudentPojo {
	
	private String Name;
	private String Semester;
	private Set<Subject> Subjects;
	private SortedSet<ExtraCourses> Courses;
	private Usn usn;
	private int id;
	
	
	public StudentPojo() {}
	
	public StudentPojo( String Name,String Semester) {
		this.Name = Name;
		this.Semester = Semester;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		Semester = semester;
	}
	public Set<Subject> getSubjects() {
		return Subjects;
	}
	public void setSubjects(Set<Subject> subjects1) {
		this.Subjects = subjects1;
	}

	public SortedSet<ExtraCourses> getCourses() {
		return Courses;
	}

	public void setCourses(SortedSet<ExtraCourses> courses) {
		Courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usn getUsn() {
		return usn;
	}

	public void setUsn(Usn usn) {
		this.usn = usn;
	}

}
