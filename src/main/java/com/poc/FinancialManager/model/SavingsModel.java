package com.poc.FinancialManager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
@Data
public class SavingsModel {

    @Id
    private String handle;
    private String userId;
    private int savings;
    private int bonus;
    private Date savingsDate;

    public  SavingsModel(){}
    public SavingsModel(String userId,Date savingsDate)
    {
        this.handle=getSavingsHandle(userId,savingsDate);
    }

    private String getSavingsHandle(String userId,Date savingsDate) {
        return userId + ":" + savingsDate;
    }


}