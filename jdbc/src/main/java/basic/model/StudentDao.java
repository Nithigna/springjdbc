package basic.model;

import java.util.List;

import com.nithigna.jdbc.Student;



public interface StudentDao {
	
	//void insert1(Student student);
	public void insert(List<Student> students);
	 
	public void insert(Student student);
	public void deleteRowByID(int id);
	
	public List<Student> getAllStudents();
	
	Student findStudentById(int id);

}