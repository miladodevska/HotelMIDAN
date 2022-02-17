package com.example.midan.repository;

import com.example.midan.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmoloyeeRepository extends JpaRepository<Employee, Long> {
}
