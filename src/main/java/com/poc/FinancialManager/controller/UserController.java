package com.poc.FinancialManager.controller;

import com.poc.FinancialManager.model.FInancialModel;
import com.poc.FinancialManager.model.UserProfile;
import com.poc.FinancialManager.dao.UserDaoRepository;
import com.poc.FinancialManager.services.FInancialModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller to manage the calls centrally.
 */
@Component
@RestController
@RequestMapping("fma/userProfile")
public class UserController {

   @Autowired
   UserDaoRepository userDaoRepository;
   @Autowired
   FInancialModelService fInancialModelService;
   


   @GetMapping(value = "/ping")
    private String checkConnection()
   {
      return ("SERVER IS UP AND RUNNING!!");
   }

   @GetMapping(value = "/getUserProfile")
   private List<UserProfile> getUserProfiles()
   {
      List<UserProfile> userProfiles= (List<UserProfile>) userDaoRepository.findAll();
      return userProfiles;
   }

   @PostMapping(value = "/saveUserProfile")
   private String saveUserProfile(@RequestBody UserProfile userProfile)
   {
      userDaoRepository.save(userProfile);
      return "SUCCESSFULLY SAVED USER :"+ userProfile.getUserId() ;
   }

   @GetMapping (value = "/getFinancialModelByUserId/{userId}")
   private FInancialModel getFinancialModelbyUserId(@PathVariable("userId") String userId)
   {
      if(fInancialModelService.getFinancialModelOfUser(userId)!=null)
      return fInancialModelService.getFinancialModelOfUser(userId);
      return null;
   }




}

