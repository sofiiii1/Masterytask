package com.example.mastery.dao;

import com.example.mastery.dto.Employee;
import com.example.mastery.dto.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String INSERT_EMPLOYEE_SQL="INSERT INTO employee (employee_id, first_name, last_name, department, job_title, gender, date_of_birth) VALUES (?,?,?,?,?,?,?)";
    private final static String UPDATE_EMPLOYEE_SQL = "UPDATE employee SET first_name=?, last_name=?, department=?, job_title=?, gender=?, date_of_birth=? WHERE employee_id=?";
    private final static String SELECT_EMPLOYEE_SQL = "SELECT * FROM employee WHERE employee_id=?";
    private final static String DELETE_EMPLOYEE_SQL = "DELETE FROM employee WHERE employee_id=?";
    private final static String SELECT_ALL_EMPLOYEES_SQL = "SELECT * FROM employee";

    RowMapper<Employee> rowMapper = (rs, rowNum) -> {
        Employee employee = new Employee();
        employee.setId(rs.getInt("employee_id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setDepartment(rs.getString("department"));
        employee.setJobTitle(rs.getString("job_title"));
        employee.setGender(Gender.valueOf(rs.getString("gender").toUpperCase()));
        employee.setDateOfBirth(rs.getDate("date_of_birth"));
        return employee;
    };

    @Override
    public Employee saveEmployee(Employee employee) {
        jdbcTemplate.update(INSERT_EMPLOYEE_SQL, employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth());
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        jdbcTemplate.update(UPDATE_EMPLOYEE_SQL, employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth(), employee.getId());
        return employee;
    }

    @Override
    public Employee getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_SQL, rowMapper, id);
    }

    @Override
    public void deleteEmployee(int id) {
        jdbcTemplate.update(DELETE_EMPLOYEE_SQL, id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query(SELECT_ALL_EMPLOYEES_SQL, rowMapper);
    }
}
