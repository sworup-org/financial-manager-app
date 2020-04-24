package com.poc.FinancialManager.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class IncomeModel {


    @Id
    private String handle;
    private String userId;
    private int salary;
    private int deduction;
    private int bonus;
    private int others;
    private Date incomeDate;

    public IncomeModel(){}

    public IncomeModel(String userId,Date incomeDate)
    {
        this.handle=userId+":"+incomeDate;
    }

}
