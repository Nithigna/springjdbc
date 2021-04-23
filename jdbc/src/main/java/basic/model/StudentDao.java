package basic.model;

import com.nithigna.jdbc.Student;



public interface StudentDao {
	public void insert(Student student);
	public void deleteRowByID(int id);

}