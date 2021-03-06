package com.poc.FinancialManager.dao;

import com.poc.FinancialManager.model.ExpenditureModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenditureModelDao extends CrudRepository<ExpenditureModel, String> {

   List<ExpenditureModel> findByUserId(String userId);

   ExpenditureModel findByHandle(String handle);

/*
  @Query("select * from expenditure_model em where em.handle like '%:userId%' order by em.expense_date DESC")
  public List<ExpenditureModel> getExpenditureModelforUserId(String userId);
*/



}
