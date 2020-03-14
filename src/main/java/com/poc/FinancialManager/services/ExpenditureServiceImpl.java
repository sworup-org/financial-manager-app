package com.poc.FinancialManager.services;


import com.poc.FinancialManager.dao.ExpenditureModelDao;
import com.poc.FinancialManager.model.ExpenditureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenditureServiceImpl  implements  ExpenditureService{

    @Autowired
    ExpenditureModelDao expenditureModelDao;
    @Autowired
    SavingsCalculator savingsCalculator;

    @Override
    public String saveExpenditureModel(ExpenditureModel expenditureModel) {

    expenditureModelDao.save(expenditureModel);
    String res=savingsCalculator.saveSavingsModelOfUserId(expenditureModel.getUserId());
    if(res.equalsIgnoreCase("SUCCESS"))
        return "SUCCESS";
    else
        return "FAILED";


    }

    @Override
    public ExpenditureModel getExpenditureModelId(int userId) {
         return  expenditureModelDao.findByUserId(userId);
    }
}
