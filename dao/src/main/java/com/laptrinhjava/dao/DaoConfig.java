package com.laptrinhjava.dao;

import com.laptrinhjava.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {
    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeServiceImpl(employeeRepository);
    }
}
