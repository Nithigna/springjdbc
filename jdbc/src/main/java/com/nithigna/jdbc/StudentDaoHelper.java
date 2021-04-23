package com.nithigna.jdbc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basic.model.StudentDao;
@Service("studentDaoHelper")

public class StudentDaoHelper {
	@Autowired
	StudentDao studentDaoImpl;

	public void insertStudents(){
		Student s1 = new Student(1, "students name1", 1, 95);
		Student s2 = new Student(2, "students name2", 2, 82);
		Student s3 = new Student(3, "students name3", 3, 76);
		Student s4 = new Student(4, "students name4", 4, 83);
		ArrayList<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		studentDaoImpl.insert(students);
		System.out.println("batch updated complete..");

	}


}
