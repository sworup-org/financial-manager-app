package com.poc.FinancialManager.dao;

import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.SavingsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SavingsModelDao extends JpaRepository<SavingsModel,String> {

    public SavingsModel findByHandle(String handle);

/*

    @Query("select *  from Savings_Model sm  where sm.handle like '%:userId%'  order by sm.savings_Date DESC")
    public List<SavingsModel> getSavingsModelforUserId(String userId);
*/

}
