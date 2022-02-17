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

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public Long getEmbg() {return embg;}

    public void setEmbg(Long embg) {this.embg = embg;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname){this.surname = surname;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public Integer getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(Integer phoneNumber) {this.phoneNumber = phoneNumber;}

    public Integer getAge() {return age;}

    public void setAge(Integer age) {this.age = age;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public Integer getWorkExperience() {return workExperience;}

    public void setWorkExperience(Integer workExperience) {this.workExperience = workExperience;}

    public DepartmentType getDepartment() {return department;}

    public void setDepartment(DepartmentType department) {this.department = department;}
}
