package com.laptrinhjava.service;

import com.laptrinhjava.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public Service service(EmployeeService employeeService) {
        return new Service(employeeService);
    }
}
