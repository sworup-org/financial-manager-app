package com.poc.FinancialManager.model;

import lombok.Data;

import java.sql.Date;

@Data
public class IncomeModelBO {

    private String userId;
    private int salary;
    private int deduction;
    private int bonus;
    private int others;
    private Date incomeDate;

    public IncomeModelBO() {
    }
}
