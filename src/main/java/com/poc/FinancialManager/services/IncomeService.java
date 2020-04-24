package com.poc.FinancialManager.services;

import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.model.IncomeModelBO;
import org.springframework.stereotype.Service;

@Service
public interface IncomeService {

    void saveIncomeModel(IncomeModel expenditureModel);
    IncomeModel getIncomeByUserId(String userId);

    IncomeModel convertIncomeBOtoDO(IncomeModelBO incomeModelBO);
}
