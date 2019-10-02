package com.poc.FinancialManager.controller;

import com.poc.FinancialManager.model.UserProfile;
import com.poc.FinancialManager.userDao.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller to manage the calls centrally.
 */
@Component
@RestController
@RequestMapping("/application")
public class UserController {

   @Autowired
   UserDaoRepository userDaoRepository;


   @GetMapping(value = "/ping")
    private String checkConnection()
   {
      return ("SERVER IS UP AND RUNNING!!");
   }

   @GetMapping(value = "/save")
   private UserProfile saveUser()
   {
      UserProfile userProfile=new UserPFrofile();
      userProfile.setUserId(1);
      userProfile.setName("Sworup Patra");
      userProfile.setAddress("Malleshpalya Bangalore");
      userProfile.setContact("9493477182");
      userProfile.setAge(26);
      userProfile.setCompanyName("SAP Labs");
      userProfile.setDesignation("Software Developer 2");
      userProfile.setExperience(2.6);
      return  (userDaoRepository.save(userProfile));
   }



}

