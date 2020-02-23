package com.poc.FinancialManager.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class SavingsModel{

    @Id
    private int userId;
    private int savings;
}
