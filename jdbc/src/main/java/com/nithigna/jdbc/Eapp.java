package com.nithigna.jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.model.EmployeeDAO;



public class Eapp {
	  public static void main(String[] args) {
	    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
	    ("bean.xml");

	    EmployeeDAO dao=(EmployeeDAO)context.getBean("employeeDAO");  
	    Employee emp = new Employee();
	    emp.setEmpName("Nithi");
	    emp.setAge(22);
	    int status = dao.save(emp);  
	    System.out.println(status);  
	            
	    // For update
	    emp.setEmpId(12);
	    emp.setAge(35);

	    dao.update(emp);

	    // For delete
	    dao.deleteEmpById(10);
	  }
	}