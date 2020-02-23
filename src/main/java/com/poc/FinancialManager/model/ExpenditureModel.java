package com.poc.FinancialManager.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class ExpenditureModel {

    @Id
    private int userId;
    private int rent;
    private int food;
    private int shopping;
    private int household;
    private int vehicle;
    private int communication;

}
