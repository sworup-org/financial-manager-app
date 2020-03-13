package com.poc.FinancialManager.services;


import com.poc.FinancialManager.dao.IncomeModelDao;
import com.poc.FinancialManager.model.IncomeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IncomeService{

@Autowired
    IncomeModelDao incomeModelDao;

    @Override
    public void saveIncomeModel(IncomeModel incomeModel) {

    incomeModelDao.save(incomeModel);
    }

    @Override
    public IncomeModel getIncomeByUserId(int userId) {

        return  incomeModelDao.findByUserId(userId);
    }
}
