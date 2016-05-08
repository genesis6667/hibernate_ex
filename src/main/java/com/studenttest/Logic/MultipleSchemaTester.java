package com.studenttest.Logic;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.studenttest.pojos.StudentPojo;

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
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("spring-appilcation-context.xml");
		MultipleSchemaTester multipleSchemaTester = new MultipleSchemaTester();

		StudentPojo student1 = (StudentPojo) context.getBean("student1");
		StudentPojo student2 = (StudentPojo) context.getBean("student2");
		StudentPojo student3 = (StudentPojo) context.getBean("student3");
		
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
		@SuppressWarnings("rawtypes")
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
