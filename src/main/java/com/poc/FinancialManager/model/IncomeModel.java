package com.poc.FinancialManager.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Income_Model")
@Data
public class IncomeModel {


    @Id
    private String handle;
    @Column(name = "User_Id")
    private String userId;
    private int salary;
    private int deduction;
    private int bonus;
    private int others;
    @Column(name = "Income_Date")
    private Date incomeDate;
    @Column(name = "total_income")
    private int totalIncome;

    public IncomeModel(){}

    public IncomeModel(String userId,Date incomeDate)
    {
        this.handle=userId+":"+incomeDate;
    }

}
