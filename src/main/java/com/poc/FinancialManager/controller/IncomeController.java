package com.poc.FinancialManager.controller;

import com.poc.FinancialManager.model.IncomeModel;
import com.poc.FinancialManager.model.IncomeModelBO;
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
    public String saveExpenditureModel(@RequestBody IncomeModelBO incomeModelBO)
    {
        IncomeModel incomeModel= incomeService.convertIncomeBOtoDO(incomeModelBO);
        incomeService.saveIncomeModel(incomeModel);
        return "SUCCESSFULLY INCOME MODEL SAVED FOR USERID: {}"+incomeModel.getUserId();

    }

    @GetMapping(value = "/getIncomeById/{userId}")
    public IncomeModel getExpenditureModel(@PathVariable("userId") String userId)
    {
        return incomeService.getIncomeByUserId(userId);


    }

}