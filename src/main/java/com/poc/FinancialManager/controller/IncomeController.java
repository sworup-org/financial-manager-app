package com.poc.FinancialManager.controller;

import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.services.ExpenditureService;
import com.poc.FinancialManager.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fma/income")
public class IncomeController
{

    @Autowired
    IncomeService incomeService;

    @PostMapping(value = "/saveIncome")
    public String saveExpenditureModel(@RequestBody IncomeModel incomeModel)
    {
        incomeService.saveIncomeModel(incomeModel);
        return "SUCCESSFULLY EXPENDITURE MODEL SAVED FOR USERID: {}"+incomeModel.getUserId();

    }

    @GetMapping(value = "/getIncomeById/{userId}")
    public IncomeModel getExpenditureModel(@PathVariable("userId") int userId)
    {
        return incomeService.getIncomeByUserId(userId);


    }

}