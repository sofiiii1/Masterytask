package com.example.mastery.service;

import com.example.mastery.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee getById(int id);
    void deleteEmployee(int id);
    List<Employee> allEmployees();
}
