package com.example.midan.repository;

import com.example.midan.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmbg(Long embg);
    Employee findByNameAndSurname(String name, String surname);
    void deleteByEmbg(Long embg);
}
