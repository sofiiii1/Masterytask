package com.example.mastery.dao;

import com.example.mastery.dto.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee getById(int id);
    void deleteEmployee(int id);
    List<Employee> allEmployees();
}
