package basic.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.nithigna.jdbc.Student;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {

	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
		System.out.println("extractData method called");
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();
		while(rs.next()) {
			Student student =  new Student();
			student.setId(rs.getInt("id"));
			student.setName(rs.getString("name"));
			student.setSem(rs.getInt("sem"));
			student.setAverage(rs.getInt("marks"));
			students.add(student);

			
		}
		return students;
	}

}
