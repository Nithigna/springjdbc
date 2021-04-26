package basic.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nithigna.jdbc.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
  @Autowired
  private JdbcTemplate jdbcTemplate; 

  final String INSERT_QUERY = "insert into employee (name, age) values (?, ?)";
  final String UPDATE_QUERY = "update employee set age = ? where id = ?";
  final String DELETE_QUERY = "delete from employee where id = ?";

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
  }

  public int save(Employee employee) {
    return jdbcTemplate.update(INSERT_QUERY, employee.getEmpName(), 
        employee.getAge());   
  }

  public void update(Employee employee) {
    int status = jdbcTemplate.update(UPDATE_QUERY, employee.getAge(), 
      employee.getEmpId()); 
    if(status != 0){
      System.out.println("Employee data updated for ID " + employee.getEmpId());
    }else{
      System.out.println("No Employee found with ID " + employee.getEmpId());
    }
  }

  public void deleteEmpById(int empId) {
    int status = jdbcTemplate.update(DELETE_QUERY, empId);
    if(status != 0){
      System.out.println("Employee data deleted whose ID is " + empId);
    }else{
      System.out.println("No Employee found with ID " + empId);
    }
  }
}