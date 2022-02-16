package com.example.midan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private int age;
    private int workExperience;
    private String department;

    public Employee() {
    }

    public Employee(String name, String surname, int age, int workExperience, String department) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workExperience = workExperience;
        this.department = department;
    }
}
