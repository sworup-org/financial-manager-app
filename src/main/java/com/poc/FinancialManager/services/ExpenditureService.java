package com.poc.FinancialManager.services;

import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.ExpenditureModelBO;
import org.springframework.stereotype.Service;

@Service
public interface ExpenditureService {

    String saveExpenditureModel(ExpenditureModel expenditureModel);
    ExpenditureModel getExpenditureModelId(String userId);

    ExpenditureModel convertExpenditureModelBOToDO(ExpenditureModelBO expenditureModelBo);
}



