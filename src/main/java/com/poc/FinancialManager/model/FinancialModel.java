package com.poc.FinancialManager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class FinancialModel {
    @Id
    private int userId;
   // private IncomeModel incomeModel;
    //private ExpenditureModel expenditureModel;
    private int savings;
}
