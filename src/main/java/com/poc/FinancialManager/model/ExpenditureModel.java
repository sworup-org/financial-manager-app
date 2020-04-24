package com.poc.FinancialManager.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
@Data
public class ExpenditureModel {

    @Id
    private String handle;
    private String userId;
    private int rent;
    private int food;
    private int shopping;
    private int household;
    private int vehicle;
    private int communication;
    private int loans;
    private Date expenseDate;

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
