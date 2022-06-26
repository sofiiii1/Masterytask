package com.example.mastery.service;

import com.example.mastery.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee getById(int id);

    void deleteEmployee(int id);

    List<Employee> getAllEmployees();
}
