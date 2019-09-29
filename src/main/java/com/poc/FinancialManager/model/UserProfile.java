package com.poc.FinancialManager.model;

import lombok.Data;

import javax.persistence.*;

/**
 * User profile details
 */
@Table(name = "USER_PROFILE")
@Entity
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private int userId;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "contact")
    private String contact;
    @Column(name = "address")
    private String address;
    @Column(name = "companyName")
    private String companyName;
    @Column(name = "designation")
    private String designation;
    @Column(name = "experience")
    private double experience;

}
