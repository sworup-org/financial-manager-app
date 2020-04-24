package com.poc.FinancialManager.services;


import com.poc.FinancialManager.dao.IncomeModelDao;
import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.model.IncomeModelBO;
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
    public IncomeModel getIncomeByUserId(String userId) {

        return  incomeModelDao.findByUserId(userId);
    }

    @Override
    public IncomeModel convertIncomeBOtoDO(IncomeModelBO incomeModelBO) {
        IncomeModel incomeModel=new IncomeModel(incomeModelBO.getUserId(),incomeModelBO.getIncomeDate());
        incomeModel.setUserId(incomeModelBO.getUserId());
        incomeModel.setBonus(incomeModelBO.getBonus());
        incomeModel.setDeduction(incomeModelBO.getDeduction());
        incomeModel.setSalary(incomeModelBO.getSalary());
        incomeModel.setOthers(incomeModelBO.getOthers());
        incomeModel.setIncomeDate(incomeModelBO.getIncomeDate());
        return incomeModel;
    }
}
