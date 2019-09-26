package com.poc.FinancialManager.model;

import lombok.Data;

/**
 * User profile details
 */
@Data
public class UserProfile {
    private String name;
    private int age;
    private String contact;
    private String address;
    private String companyName;
    private String designation;
    private double experience;

}
