package com.poc.FinancialManager.controller;


import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.services.ExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("fma/expenditure")
public class ExependitureController {

    @Autowired
    ExpenditureService expenditureService;

    @PostMapping(value = "/saveExpenditure")
    public String saveExpenditureModel(@RequestBody  ExpenditureModel expenditureModel)
    {
        expenditureService.saveExpenditureModel(expenditureModel);
        return "SUCCESSFULLY EXPENDITURE MODEL SAVED FOR USERID: {}"+expenditureModel.getUserId();

    }

    @GetMapping(value = "/getExpenditureById/{userId}")
    public ExpenditureModel getExpenditureModel(@PathVariable("userId") int userId)
    {
       return expenditureService.getExpenditureModelId(userId);


    }




}
