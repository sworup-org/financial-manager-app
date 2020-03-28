package com.poc.FinancialManager.services;

import com.poc.FinancialManager.model.IncomeModel;
import org.springframework.stereotype.Service;

@Service
public interface IncomeService {

    void saveIncomeModel(IncomeModel expenditureModel);
    IncomeModel getIncomeByUserId(int userId);
}
