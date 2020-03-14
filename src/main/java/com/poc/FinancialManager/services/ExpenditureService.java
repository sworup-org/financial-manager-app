package com.poc.FinancialManager.services;

import com.poc.FinancialManager.model.ExpenditureModel;
import org.springframework.stereotype.Service;

@Service
public interface ExpenditureService {

    String saveExpenditureModel(ExpenditureModel expenditureModel);
    ExpenditureModel getExpenditureModelId(int userId);

}
