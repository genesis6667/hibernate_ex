package com.studenttest.Logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.studenttest.pojos.ExtraCourses;
import com.studenttest.pojos.StudentPojo;
import com.studenttest.pojos.Subject;
import com.studenttest.pojos.Usn;

public class MultipleSchemaTester {
	SessionFactory sessionFactory = createNewSessionFactory();

	@SuppressWarnings("deprecation")
	private SessionFactory createNewSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		MultipleSchemaTester multipleSchemaTester = new MultipleSchemaTester();

		StudentPojo student1 = new StudentPojo("Abish", "3");
		StudentPojo student2 = new StudentPojo("Rabish", "3");
		StudentPojo student3 = new StudentPojo("rajiv", "4");

		Set<StudentPojo> studentList1 = new HashSet<StudentPojo>();
		Set<StudentPojo> studentList2 = new HashSet<StudentPojo>();
		Set<StudentPojo> studentList3 = new HashSet<StudentPojo>();

		studentList1.add(student1);
		studentList1.add(student3);

		studentList2.add(student1);
		studentList2.add(student2);

		studentList3.add(student2);
		studentList3.add(student3);

		Subject subject1 = new Subject("java", 6);
		Subject subject2 = new Subject("C++", 6);
		Subject subject3 = new Subject("cobol", 4);

		Set<Subject> subjects1 = new HashSet<Subject>();
		Set<Subject> subjects2 = new HashSet<Subject>();
		Set<Subject> subjects3 = new HashSet<Subject>();

		subjects1.add(subject1);
		subjects1.add(subject2);

		subjects2.add(subject2);
		subjects2.add(subject3);

		subjects3.add(subject1);
		subjects3.add(subject3);

		student1.setSubjects(subjects1);
		student2.setSubjects(subjects2);
		student3.setSubjects(subjects3);

		subject1.setStudent(studentList1);
		subject2.setStudent(studentList2);
		subject3.setStudent(studentList3);
		
		
		Usn usn1 = new Usn();
		usn1.setUsn("1601");
		Usn usn2 = new Usn();
		usn2.setUsn("1602");
		Usn usn3 = new Usn();
		usn3.setUsn("1603");

		student1.setUsn(usn1);
		usn1.setStudent(student1);

		student2.setUsn(usn2);
		usn2.setStudent(student2);

		student3.setUsn(usn3);
		usn3.setStudent(student3);

		ExtraCourses courses1 = new ExtraCourses("Lam");
		ExtraCourses courses2 = new ExtraCourses("San");
		ExtraCourses courses3 = new ExtraCourses("Den");

		TreeSet<ExtraCourses> set3 = new TreeSet<ExtraCourses>();
		set3.add(courses1);
		set3.add(courses2);
		set3.add(courses3);
		
		student3.setCourses(set3);
		// College college = new College("ABC");
		multipleSchemaTester.addToDb(student1);
		multipleSchemaTester.addToDb(student2);
		multipleSchemaTester.addToDb(student3);
		System.out.println("\n\n------------CRITERIA--------------\n\n");
		multipleSchemaTester.listStudentsBasedOnCriteria();
		System.out.println("\n\n------------HQL-------------------\n\n");
		multipleSchemaTester.listStudentByHQL();

	}

	private void addToDb(StudentPojo student) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	private void listStudentsBasedOnCriteria()
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(StudentPojo.class);
		criteria.add(Restrictions.lt("id", 3));
		@SuppressWarnings("rawtypes")
		List list = criteria.list();
		for(@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();itr.hasNext();)
		{
			StudentPojo studentPojo = (StudentPojo)itr.next();
			System.out.println(studentPojo.getName());
		}
		session.close();
	}
	
	private void listStudentByHQL()
	{
		String Query = "FROM StudentPojo S where S.id between 1 and 3";
		Session session = sessionFactory.openSession();
		List list = session.createQuery(Query).list();
		for(@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();itr.hasNext();)
		{
			StudentPojo studentPojo = (StudentPojo)itr.next();
			System.out.println(studentPojo.getName());
		}
		session.close();
	}

}
