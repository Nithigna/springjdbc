package com.nithigna.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.model.StudentDao;
import basic.model.StudentDaoImp;


public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//		Student myStudent = new Student(5, "bapji", 5, 55);
//		Student anotherStudent = new Student(6,"chandra",6,66);
//		StudentDao studentDao = (StudentDao) context.getBean("studentDao");
//		//= new StudentDaoImpl();
//		studentDao.insert(myStudent);
		
		
		//StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		StudentDaoImp studentDao = (StudentDaoImp) context.getBean("studentDao");
		
		//insertStudent(studentDao);
		studentDao.cleanUp();

		studentDao.deleteRowByID(1);
	}

	
}