package com.poc.FinancialManager.controller;


import com.poc.FinancialManager.model.ExpenditureModel;
import com.poc.FinancialManager.model.ExpenditureModelBO;
import com.poc.FinancialManager.services.ExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fma/expenditure")
public class ExependitureController {

    @Autowired
    ExpenditureService expenditureService;

    @PostMapping(value = "/saveExpenditure")
    public String saveExpenditureModel(@RequestBody ExpenditureModelBO expenditureModelBo)
    {

        ExpenditureModel expenditureModel=expenditureService.convertExpenditureModelBOToDO(expenditureModelBo);

        if(expenditureService.saveExpenditureModel(expenditureModel).equalsIgnoreCase("SUCCESS"))
        return "SUCCESSFULLY EXPENDITURE MODEL AND SAVINGS MODEL CREATED FOR USERID: "+expenditureModel.getUserId();
        else if (expenditureService.saveExpenditureModel(expenditureModel).equalsIgnoreCase("NO USERPROFILE"))
            return "NO USER PROFILE PRESENT FOR :"+expenditureModel.getUserId();
        return "EXPENDITURE MODEL CREATION SUCCESSFUL BUT SAVINGS MODEL FAILED FOR USERID:" +expenditureModel.getUserId();


    }

    @GetMapping(value = "/getExpenditureById/{userId}")
    public List<ExpenditureModel> getExpenditureModel(@PathVariable("userId") String userId)
    {
       return expenditureService.getExpenditureModelId(userId);


    }




}
