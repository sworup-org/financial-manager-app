package com.poc.FinancialManager.services;

import com.poc.FinancialManager.dao.ExpenditureModelDao;
import com.poc.FinancialManager.dao.IncomeModelDao;
import com.poc.FinancialManager.dao.SavingsModelDao;
import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.model.SavingsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsCalculator {

    @Autowired
    IncomeModelDao incomeModelDao;
    @Autowired
    ExpenditureModelDao expenditureModelDao;
    @Autowired
    SavingsModelDao savingsModelDao;

    public String saveSavingsModelOfUserId(String userId)
    {
        IncomeModel incomeModel= incomeModelDao.findByUserId(userId);
        ExpenditureModel expenditureModel= expenditureModelDao.findByUserId(userId);

        if(incomeModel==null || expenditureModel==null)
            return "FAILED";

        int netIncome= incomeModel.getSalary()+incomeModel.getBonus()+incomeModel.getOthers()-incomeModel.getDeduction();
        int netExpenditure= expenditureModel.getCommunication()+expenditureModel.getFood()+expenditureModel.getHousehold()+expenditureModel.getLoans()+expenditureModel.getRent()+expenditureModel.getShopping()+expenditureModel.getVehicle();
        int savings=netIncome-netExpenditure;

        SavingsModel savingsModel=new SavingsModel();
        savingsModel.setSavings(savings);
        savingsModel.setUserId(userId);

        savingsModelDao.save(savingsModel);
        return "SUCCESS";



    }


}
