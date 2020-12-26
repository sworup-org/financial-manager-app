package com.poc.FinancialManager.services;


import com.poc.FinancialManager.dao.IncomeModelDao;
import com.poc.FinancialManager.dao.UserDaoRepository;
import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.model.IncomeModelBO;
import com.poc.FinancialManager.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    IncomeModelDao incomeModelDao;
    @Autowired
    UserDaoRepository userDaoRepository;
    @Autowired
    SavingsCalculator savingsCalculator;

    @Override
    public String saveIncomeModel(IncomeModel incomeModel) {
        Optional<UserProfile> userProfile= userDaoRepository.findById(incomeModel.getUserId());
        if(userProfile.isPresent()) {
            incomeModelDao.save(incomeModel);
            savingsCalculator.saveSavingsModelOnIncome(incomeModel);
            return "SUCCESS";
        }
        else return "NO USERPROFILE";
    }

    @Override
    public List<IncomeModel> getIncomeByUserId(String userId) {

        return incomeModelDao.findByUserId(userId);
    }

    @Override
    public IncomeModel convertIncomeBOtoDO(IncomeModelBO incomeModelBO) {
        IncomeModel incomeModel = new IncomeModel(incomeModelBO.getUserId(), incomeModelBO.getIncomeDate());
        incomeModel.setUserId(incomeModelBO.getUserId());
        incomeModel.setBonus(incomeModelBO.getBonus());
        incomeModel.setDeduction(incomeModelBO.getDeduction());
        incomeModel.setSalary(incomeModelBO.getSalary());
        incomeModel.setOthers(incomeModelBO.getOthers());
        incomeModel.setIncomeDate(incomeModelBO.getIncomeDate());
        int netIncome=incomeModelBO.getSalary()+incomeModelBO.getBonus()+incomeModelBO.getOthers()-incomeModelBO.getDeduction();
        incomeModel.setTotalIncome(netIncome);
        return incomeModel;
    }

   /* @Override
    public List<IncomeModel> getAllIncomeModelforUserId(String UserId) {
        return null;
    }*/

   /* @Override
    public List<IncomeModel> getAllIncomeModelforUserId(String UserId) {
        return incomeModelDao.getIncomeModelforUserId(UserId);
    }*/
}
