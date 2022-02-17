package com.example.midan.model;

import com.example.midan.model.Enumerations.DepartmentType;

import javax.persistence.*;

@Entity
public class Employee {

    public Employee() {
    }

    public Employee(Long embg, String name, String surname, String email, Integer phoneNumber, Integer age, String address, Integer workExperience, DepartmentType department) {
        this.embg = embg;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.address = address;
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

    private String address;

    private Integer workExperience;

    @Enumerated(EnumType.STRING)
    private DepartmentType department;

}
