package com.poc.FinancialManager.dao;

import com.poc.FinancialManager.model.ExpenditureModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenditureModelDao extends CrudRepository<ExpenditureModel, String> {

  public ExpenditureModel findByUserId(int userId);


}
