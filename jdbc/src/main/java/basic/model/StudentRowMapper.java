package basic.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nithigna.jdbc.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		int sem = rs.getInt("sem");
		int avg = rs.getInt("marks");
		Student newStudent = new Student(id,name,sem,avg);
		//System.out.println("maprow method has been called");
		
		return newStudent;
	}
	
}



