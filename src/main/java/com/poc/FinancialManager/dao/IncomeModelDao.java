package com.poc.FinancialManager.dao;

import com.poc.FinancialManager.model.IncomeModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeModelDao extends CrudRepository<IncomeModel,String> {

    public IncomeModel findByUserId(String userId);
    public IncomeModel findByHandle(String handle);

/*
    @Query("select *  from Income_Model im where im.handle like '%:userId%' order by im.savings_Date DESC")
    public List<IncomeModel> getIncomeModelforUserId(String userId);*/

}
