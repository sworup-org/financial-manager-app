package com.poc.FinancialManager.model;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Table(name = "Savings_Model")
@Data
public class SavingsModel {

    @Id
    @Column(name = "handle")
    private String handle;
    @Column(name = "user_Id")
    private String userId;
    @Column(name = "savings")
    private int savings;
    @Column(name = "bonus")
    private int bonus;
    @Column(name = "savings_date")
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