package com.poc.FinancialManager.dao;

import com.poc.FinancialManager.model.SavingsModel;
import org.springframework.data.repository.CrudRepository;

public interface SavingsModelDao extends CrudRepository<SavingsModel,String> {

    public SavingsModel findByHandle(String handle);

}
