package com.example.midan.service;

import com.example.midan.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> listAllEmployees();
    Employee findById(Long id);
    Employee create(String name, String surname, Integer age, Integer workExperience, String department);
    Employee update();
    Employee delete(Long id);
}
