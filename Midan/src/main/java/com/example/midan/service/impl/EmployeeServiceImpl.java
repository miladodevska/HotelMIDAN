package com.example.midan.service.impl;

import com.example.midan.model.Employee;
import com.example.midan.model.Enumerations.DepartmentType;
import com.example.midan.model.Exceptions.InvalidEmployeeIdException;
import com.example.midan.repository.EmployeeRepository;
import com.example.midan.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> listAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(InvalidEmployeeIdException::new);
    }

    @Override
    public Employee findByNameAndSurname(String name, String surname) {
        return this.employeeRepository.findByNameAndSurname(name, surname);
    }

    @Override
    public Employee findByEmbg(Long embg) {
        return this.employeeRepository.findByEmbg(embg);
    }

    @Override
    public Optional<Employee> save(Long embg, String name, String surname, String email, String phoneNumber, Integer age, String address, Integer workExperience, DepartmentType department) {
        this.employeeRepository.deleteByEmbg(embg);
        return Optional.of(this.employeeRepository.save(new Employee(embg, name, surname, email, phoneNumber, age, address, workExperience, department)));
    }

    @Override
    public Employee create(Long embg, String name, String surname, String email, String phoneNumber, Integer age, String address, Integer workExperience, DepartmentType department) {
        Employee employee = new Employee(embg, name, surname, email, phoneNumber, age, address, workExperience, department);
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Long embg, String name, String surname, String email, String phoneNumber, Integer age, String address, Integer workExperience, DepartmentType department) {
        Employee employee = this.findById(id);
        employee.setEmbg(embg);
        employee.setName(name);
        employee.setSurname(surname);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setAge(age);
        employee.setAddress(address);
        employee.setWorkExperience(workExperience);
        employee.setDepartment(department);
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee delete(Long id) {
        Employee employee = this.findById(id);
        this.employeeRepository.delete(employee);
        return employee;
    }
}
