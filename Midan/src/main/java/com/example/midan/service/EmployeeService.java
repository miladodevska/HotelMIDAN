package com.example.midan.service;

import com.example.midan.model.Employee;
import com.example.midan.model.Enumerations.DepartmentType;

import java.util.List;

public interface EmployeeService {

    List<Employee> listAllEmployees();

    Employee findById(Long id);

    Employee findByNameAndSurname(String name, String surname);

    Employee findByEmbg(Long embg);

    Employee create(Long embg, String name, String surname, String email, Integer phoneNumber, Integer age, String address, Integer workExperience, DepartmentType department);

    Employee update(Long id, Long embg, String name, String surname, String email, Integer phoneNumber, Integer age, String address, Integer workExperience, DepartmentType department);

    Employee delete(Long id);
}
