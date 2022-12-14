package com.laptrinhjava;

import com.laptrinhjava.dao.DaoConfig;
import com.laptrinhjava.service.ServiceConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"com.laptrinhjava.dao", "com.laptrinhjava.controller"})
@EnableJpaRepositories("com.laptrinhjava.dao")
@EntityScan("com.laptrinhjava.entity")
@Import({ServiceConfig.class, DaoConfig.class})
public class EmployeeConfiguration {
//    @Bean
//    public Service service (EmployeeService employeeService){
//        return new Service(employeeService);
//    }
//    @Bean
//    public EmployeeService employeeService(EmployeeRepository employeeRepository){
//        return  new EmployeeServiceImpl(employeeRepository);
//    }
}
