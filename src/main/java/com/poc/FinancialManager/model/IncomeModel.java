package com.poc.FinancialManager.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class IncomeModel {


    @Id
    private int userId;
    private int salary;
    private int deduction;
    private int bonus;
    private int others;
}
