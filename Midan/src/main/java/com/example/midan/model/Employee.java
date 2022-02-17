package com.example.midan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    public Employee() {
    }

    public Employee(Long embg, String name, String surname, String email, Integer phoneNumber, Integer age, Integer workExperience, String department) {
        this.embg = embg;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.workExperience = workExperience;
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long embg;

    private String name;

    private String surname;

    private String email;

    private Integer phoneNumber;

    private Integer age;

    private Integer workExperience;

    private String department;

}
