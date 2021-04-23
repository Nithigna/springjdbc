package com.nithigna.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.model.StudentDao;
import basic.model.StudentDaoImp;


public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

		
		//StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		StudentDaoImp studentDao = (StudentDaoImp) context.getBean("studentDao");
		
		//System.out.println(studentDao.findStudentById(3));//aspect 
		
		//insertStudent(studentDao);
		//studentDao.cleanUp();
		
		//StudentDaoHelper helper=  context.getBean("studentDaoHelper",StudentDaoHelper.class);
		//helper.insertStudents();
		
		
		
		List<Student> students = studentDao.getAllStudents();
		printStudents(students);// rowmapper
		
		

		//studentDao.deleteRowByID(1);
	}
	
	/*private static void insertStudent(StudentDao studentDao) {
		Student myStudent = new Student(5, "bapji", 5, 55);
		Student anotherStudent = new Student(6,"chandra",6,66);
		//= new StudentDaoImpl();
		studentDao.insert(myStudent);
		
		
	}*/

	private static void printStudents(List<Student> students) {
		for(Student s : students) {
			System.out.println(s);
		}
	
}
}