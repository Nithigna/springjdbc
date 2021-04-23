package basic.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.stereotype.Repository;

import com.nithigna.jdbc.Student;



@Repository("studentDao")
public class StudentDaoImp  implements StudentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate ;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}




	@Override
	public void insert(Student student) {
		//INSERT INTO `student` (`_id`, `name`, `semester`, `average`) 
		//VALUES ('9', 'yahas', '2', '67');
		String sql = "INSERT INTO students VALUES (?,?,?,?)";
		Object[] objects =	{student.getId(),student.getName(),student.getSem(),student.getAverage()};

		int no_rows_inserted =	jdbcTemplate.update(sql,objects);
		System.out.println("no of rows inserted  is"+ no_rows_inserted);
	}




	@Override
	public void deleteRowByID(int id) {
		// TODO Auto-generated method stub
		String delSQL = "DELETE FROM students where id = ?";
        int noRecordsdel = jdbcTemplate.update(delSQL,id);
        System.out.println(noRecordsdel);

	}
	
	public void cleanUp() {
		String sql = "TRUNCATE TABLE STUDENTS";
		jdbcTemplate.update(sql);
		System.out.println("table cleaned");
	}




	@Override
	public void insert(List<Student> students) {
		String sql = "INSERT INTO students VALUES (?,?,?,?)";
		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		for(Student student : students) {
			Object[] studentData =	{student.getId(),student.getName(),student.getSem(),student.getAverage()};
			sqlArgs.add(studentData);
		}
		
		jdbcTemplate.batchUpdate(sql, sqlArgs);		
	}




	@Override
	public List<Student> getAllStudents() {
		String sql = "SELECT * FROM STUDENTS";
		List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
		return students;
	}




	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	/*
	 * @Override public Student findStudentById(int id) { String sql =
	 * "SELECT * FROM STUDENT WHERE id= ?"; Student student=
	 * jdbcTemplate.queryForObject(sql, new
	 * BeanPropertyRowMapper<Student>(Student.class),id); // TODO Auto-generated
	 * method stub return student; }
	 */




	
	




	
	

	
}
