package com.poc.FinancialManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.poc.FinancialManager")
public class FinancialManagerApplication {

  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(FinancialManagerApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(FinancialManagerApplication.class, args);
  }
}
