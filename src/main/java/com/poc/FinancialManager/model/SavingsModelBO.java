package com.poc.FinancialManager.model;

import lombok.Data;

import java.sql.Date;

@Data
public class SavingsModelBO {
    private String userId;
    private int savings;
    private int bonus;
    private Date savingsDate;
}
