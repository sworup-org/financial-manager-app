package com.poc.FinancialManager.services;

import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.model.IncomeModelBO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncomeService {

    String saveIncomeModel(IncomeModel expenditureModel);
    List<IncomeModel> getIncomeByUserId(String userId);

    IncomeModel convertIncomeBOtoDO(IncomeModelBO incomeModelBO);

   // List<IncomeModel> getAllIncomeModelforUserId(String UserId);
}
