package com.poc.FinancialManager.model;

import lombok.Data;

import javax.persistence.*;

/**
 * User profile details
 */
@Entity
@Data
@Table(name = "User_Profile")
public class UserProfile {
    @Id
    @Column(name = "user_Id")
    private String userId;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "contact")
    private String contact;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "designation")
    private String designation;
    @Column(name = "experience")
    private double experience;
}
