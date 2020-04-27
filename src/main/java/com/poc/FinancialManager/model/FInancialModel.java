package com.poc.FinancialManager.model;


import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class FInancialModel {

    private String userId;
    private List<IncomeModel> incomeModel;
    private List<ExpenditureModel> expenditureModel;
    private SavingsModel savingsModel;
    private Date financialModelDate;
    private int totalExpense;
    private int totalIncome;

}
