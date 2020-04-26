package com.poc.FinancialManager.services;

import com.poc.FinancialManager.dao.ExpenditureModelDao;
import com.poc.FinancialManager.dao.IncomeModelDao;
import com.poc.FinancialManager.dao.SavingsModelDao;
import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.model.SavingsModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SavingsCalculator {

    @Autowired
    IncomeModelDao incomeModelDao;
    @Autowired
    ExpenditureModelDao expenditureModelDao;
    @Autowired
    SavingsModelDao savingsModelDao;


    @Transactional
    public String saveSavingsModelOnExpenditure(ExpenditureModel expenditureModel) {
        IncomeModel incomeModel = incomeModelDao.findByHandle(expenditureModel.getHandle());

        if (incomeModel == null || expenditureModel == null)
            return "FAILED";

        int netIncome = incomeModel.getSalary() + incomeModel.getBonus() + incomeModel.getOthers() - incomeModel.getDeduction();
        int netExpenditure = expenditureModel.getCommunication() + expenditureModel.getFood() + expenditureModel.getHousehold() + expenditureModel.getLoans() + expenditureModel.getRent() + expenditureModel.getShopping() + expenditureModel.getVehicle();
        int savings = netIncome - netExpenditure;

        SavingsModel savingsModel = new SavingsModel();
        savingsModel.setSavings(savings);
        savingsModel.setUserId(expenditureModel.getUserId());
        savingsModel.setHandle(expenditureModel.getHandle());
        savingsModel.setSavingsDate(expenditureModel.getExpenseDate());
        savingsModelDao.save(savingsModel);
        return "SUCCESS";

    }

    @Transactional
    public String saveSavingsModelOnIncome(IncomeModel incomeModel) {
        SavingsModel savingsModel = savingsModelDao.findByHandle(incomeModel.getHandle());
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        int netIncome = incomeModel.getSalary() + incomeModel.getBonus() + incomeModel.getOthers() - incomeModel.getDeduction();
        if (savingsModel == null) {
            Transaction tx=session.beginTransaction();
            Query query = session.createQuery("from SavingsModel sm order by sm.savingsDate DESC", SavingsModel.class);
            query.setMaxResults(1);
            SavingsModel last = (SavingsModel) query.uniqueResult();

            if (last == null) {
                savingsModel = new SavingsModel();
                savingsModel.setSavings(netIncome);
                savingsModel.setUserId(incomeModel.getUserId());
                savingsModel.setHandle(incomeModel.getHandle());
                savingsModel.setSavingsDate(incomeModel.getIncomeDate());
                savingsModelDao.save(savingsModel);
                return "No Income or Expenditure declared yet";
            }

            int netSavings = ((savingsModel.getSavings() + netIncome));

            query = session.createQuery("Update  SavingsModel sm  set sm.savings= :netSavings where sm.handle= :handle ",SavingsModel.class);
            query.setParameter(0, netSavings);
            query.setParameter(1, savingsModel.getHandle());
            query.executeUpdate();

        }

        return "SUCCESS";

    }


}
