package com.poc.FinancialManager.services;


import com.poc.FinancialManager.dao.ExpenditureModelDao;
import com.poc.FinancialManager.model.ExpenditureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenditureServiceImpl  implements  ExpenditureService{

    @Autowired
    ExpenditureModelDao expenditureModelDao;

    @Override
    public void saveExpenditureModel(ExpenditureModel expenditureModel) {

    expenditureModelDao.save(expenditureModel);

    }

    @Override
    public ExpenditureModel getExpenditureModelId(int userId) {
         return  expenditureModelDao.findByUserId(userId);
    }
}
