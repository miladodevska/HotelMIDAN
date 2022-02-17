package com.example.midan.service;

import com.example.midan.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> listAllEmployees();

    Employee findById(Long id);

    Employee findByName(String name);

    Employee create(Long embg, String name, String surname, String email, Integer phoneNumber, Integer age, String address, Integer workExperience, String department);

    Employee update(Long id, Long embg, String name, String surname, String email, Integer phoneNumber, Integer age, String address, Integer workExperience, String department);

    Employee delete(Long id);
}
