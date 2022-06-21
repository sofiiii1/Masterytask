package com.example.mastery.dao;

import com.example.mastery.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper<Employee> rowMapper=(rs,rowNum)->{
        Employee employee=new Employee();
        employee.setId(rs.getInt("employee_id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setDepartment(rs.getString("department"));
        employee.setJobTitle(rs.getString("job_title"));
        employee.setGender(rs.getString("gender"));
        employee.setDateOfBirth(rs.getDate("date_of_birth"));

        return employee;
    };

    @Override
    public Employee saveEmployee(Employee employee) {
        String sql="INSERT INTO employee (employee_id, first_name, last_name, department, job_title, gender, date_of_birth) VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth());
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        String sql="UPDATE employee SET first_name=?, last_name=?, department=?, job_title=?, gender=?, date_of_birth=? WHERE employee_id=?";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth(), employee.getId());
        return employee;
    }

    @Override
    public Employee getById(int id) {
        String sql="SELECT * FROM employee WHERE employee_id=?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public void deleteEmployee(int id) {
        String sql="DELETE FROM employee WHERE employee_id=?";
        jdbcTemplate.update(sql,id);

    }

    @Override
    public List<Employee> allEmployees() {
        String sql="SELECT * FROM employee";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
