package com.poc.FinancialManager.model;


import lombok.Data;

import java.util.List;

@Data
public class ExpenditureModel {

    private int userId;
    private int rent;
    private int food;
    private int shopping;
    private int household;
    private List<Integer> emis;
    private int vehicle;
    private int communication;

}
