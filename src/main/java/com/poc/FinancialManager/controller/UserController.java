package com.poc.FinancialManager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller to manage the calls centrally.
 */
@RestController
@RequestMapping("/application")
public class UserController {

   @GetMapping(value = "/ping")
    private String checkConnection()
   {
      return ("SERVER IS UP AND RUNNING!!");
   }
}
