package com.poc.FinancialManager.model;

import lombok.Data;

import java.sql.Date;

@Data
public class ExpenditureModelBO {
    private String userId;
    private int rent;
    private int food;
    private int shopping;
    private int household;
    private int vehicle;
    private int communication;
    private int loans;
    private Date expenseDate;
}
