package com.poc.FinancialManager.services;


import com.poc.FinancialManager.dao.ExpenditureModelDao;
import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.ExpenditureModelBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenditureServiceImpl  implements  ExpenditureService{

    @Autowired
    ExpenditureModelDao expenditureModelDao;
    @Autowired
    SavingsCalculator savingsCalculator;

    @Override
    public String saveExpenditureModel(ExpenditureModel expenditureModel) {

    expenditureModelDao.save(expenditureModel);
    String res=savingsCalculator.saveSavingsModelOnExpenditure(expenditureModel);
    if(res.equalsIgnoreCase("SUCCESS"))
        return "SUCCESS";
    else
        return "FAILED";


    }

    @Override
    public ExpenditureModel getExpenditureModelId(String userId) {
         return  expenditureModelDao.findByUserId(userId);
    }

    @Override
    public ExpenditureModel convertExpenditureModelBOToDO(ExpenditureModelBO expenditureModelBo) {
        ExpenditureModel expenditureModel=new ExpenditureModel(expenditureModelBo.getUserId(),expenditureModelBo.getExpenseDate());
        expenditureModel.setUserId(expenditureModelBo.getUserId());
        expenditureModel.setCommunication(expenditureModelBo.getCommunication());
        expenditureModel.setExpenseDate(expenditureModelBo.getExpenseDate());
        expenditureModel.setFood(expenditureModelBo.getFood());
        expenditureModel.setVehicle(expenditureModelBo.getVehicle());
        expenditureModel.setHousehold(expenditureModelBo.getHousehold());
        expenditureModel.setLoans(expenditureModelBo.getLoans());
        expenditureModel.setRent(expenditureModelBo.getRent());
        expenditureModel.setShopping(expenditureModelBo.getShopping());

        int netExpenditure=expenditureModelBo.getFood()+expenditureModelBo.getVehicle()+expenditureModelBo.getCommunication()+expenditureModelBo.getHousehold()+expenditureModelBo.getRent()+expenditureModelBo.getLoans()+expenditureModelBo.getShopping();
        expenditureModel.setTotalExpense(netExpenditure);
        return expenditureModel;
    }

   /* @Override
    public List<ExpenditureModel> getAllExpenditureModelforUserId(String UserId) {
        return  expenditureModelDao.getExpenditureModelforUserId(UserId);
    }*/
}
