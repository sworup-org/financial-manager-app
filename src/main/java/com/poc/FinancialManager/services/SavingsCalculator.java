package com.poc.FinancialManager.services;

import com.poc.FinancialManager.dao.SavingsModelDao;
import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.model.SavingsModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SavingsCalculator {

    @Autowired
    SavingsModelDao savingsModelDao;


    @Transactional
    public String saveSavingsModelOnExpenditure(ExpenditureModel expenditureModel) {
        SavingsModel savingsModel = savingsModelDao.findByHandle(expenditureModel.getHandle());
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        int netExpenditure = expenditureModel.getCommunication() + expenditureModel.getFood() + expenditureModel.getHousehold() + expenditureModel.getLoans() + expenditureModel.getRent() + expenditureModel.getShopping() + expenditureModel.getVehicle();

        //Savings not available for the expenditure day.

        if (savingsModel == null) {
            Query query = session.createQuery("from SavingsModel sm order by sm.savingsDate DESC", SavingsModel.class);
            query.setMaxResults(1);
            SavingsModel last = (SavingsModel) query.uniqueResult();

            //check if the last is also Null then error to be thrown as Income not updated
            if(last!=null)
            {
                int netSavings=last.getSavings()-netExpenditure;
                savingsModel = new SavingsModel(expenditureModel.getUserId(),expenditureModel.getExpenseDate());
                savingsModel.setSavings(netSavings);
                savingsModel.setUserId(expenditureModel.getUserId());
                savingsModel.setSavingsDate(expenditureModel.getExpenseDate());
                savingsModelDao.save(savingsModel);
            }
            else {
                return "FAILED";
            }

        }
        // Savings model available for the day

        else {

            int savings = savingsModel.getSavings() - netExpenditure;

            savingsModel = new SavingsModel(expenditureModel.getUserId(), expenditureModel.getExpenseDate());
            savingsModel.setSavings(savings);
            savingsModel.setUserId(expenditureModel.getUserId());
            savingsModel.setHandle(expenditureModel.getHandle());
            savingsModel.setSavingsDate(expenditureModel.getExpenseDate());
            savingsModelDao.save(savingsModel);
        }
        return "SUCCESS";

    }

    @Transactional
    public String saveSavingsModelOnIncome(IncomeModel incomeModel) {
        SavingsModel savingsModel = savingsModelDao.findByHandle(incomeModel.getHandle());
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        int netIncome = incomeModel.getSalary() + incomeModel.getBonus() + incomeModel.getOthers() - incomeModel.getDeduction();
        if (savingsModel == null) {
            Query query = session.createQuery("from SavingsModel sm where userId = :userId order by sm.savingsDate DESC", SavingsModel.class);
           query.setParameter("userId",incomeModel.getUserId());
            query.setMaxResults(1);
            SavingsModel last = (SavingsModel) query.uniqueResult();

            //If 1st Income of the person as entry

            if (last == null) {
                savingsModel = new SavingsModel(incomeModel.getUserId(),incomeModel.getIncomeDate());
                savingsModel.setSavings(netIncome);
                savingsModel.setUserId(incomeModel.getUserId());
                savingsModel.setSavingsDate(incomeModel.getIncomeDate());
                savingsModelDao.save(savingsModel);
                return "SUCCESS";
            }

            //if the person has already some savings.

            else if(last!=null)
            {
                int netSavings = ((last.getSavings() + netIncome));
                savingsModel=new SavingsModel(incomeModel.getUserId(),incomeModel.getIncomeDate());
                savingsModel.setSavingsDate(incomeModel.getIncomeDate());
                savingsModel.setSavings(netSavings);
                savingsModel.setUserId(incomeModel.getUserId());
                savingsModelDao.save(savingsModel);
                return "SUCCESS";
            }
            return "FAILED";
        }

        return "FAILED";

    }


}
