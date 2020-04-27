package com.poc.FinancialManager.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Table(name = "Expenditure_Model")
@Data
public class ExpenditureModel {

    @Id
    private String handle;
    @Column(name = "User_Id")
    private String userId;
    private int rent;
    private int food;
    private int shopping;
    private int household;
    private int vehicle;
    private int communication;
    private int loans;
    @Column(name = "Expense_Date")
    private Date expenseDate;
    @Column(name = "Total_Expense")
    private int totalExpense;

    public ExpenditureModel(){}

    public ExpenditureModel(String userId,Date expenseDate)
    {
        this.handle=getHandleId(userId,expenseDate);
    }

    private String getHandleId(String userId,Date expenseDate)
    {

        return userId+":"+expenseDate;
    }


}
