package com.poc.FinancialManager.model;

import lombok.Data;

@Data
public class FinancialModel {
    
    private int userId;
    private IncomeModel incomeModel;
    private ExpenditureModel expenditureModel;
    private int savings;
}
