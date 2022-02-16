package com.example.midan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    public Employee() {
    }

    public Employee(String name, String surname, String email, Integer age, Integer workExperience, String department) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.workExperience = workExperience;
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String email;

    private Integer age;

    private Integer workExperience;

    private String department;

}
