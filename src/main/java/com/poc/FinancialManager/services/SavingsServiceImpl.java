package com.poc.FinancialManager.services;

import com.poc.FinancialManager.dao.SavingsModelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsServiceImpl implements SavingsService {

    @Autowired
    SavingsModelDao savingsModelDao;

   /* @Override
    public List<SavingsModel> getAllSavingsModelforUserId(String userId) {
        List<SavingsModel> savingsModelList=savingsModelDao.getSavingsModelforUserId(userId);
        return savingsModelList;

    }*/
}
