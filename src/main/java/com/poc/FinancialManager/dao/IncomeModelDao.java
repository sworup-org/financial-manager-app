package com.poc.FinancialManager.dao;

import com.poc.FinancialManager.model.IncomeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeModelDao extends CrudRepository<IncomeModel,String> {

    public IncomeModel findByUserId(String userId);

}
