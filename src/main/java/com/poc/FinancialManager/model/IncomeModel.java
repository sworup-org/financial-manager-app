package com.poc.FinancialManager.model;


import lombok.Data;

@Data
public class IncomeModel {


    private int userId;
    private int salary;
    private int deduction;
    private int bonus;
    private int others;
}
