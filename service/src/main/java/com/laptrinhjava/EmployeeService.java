package com.laptrinhjava;

import com.laptrinhjava.service.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getEmployees();

    List<EmployeeDTO> searchEmployees(String query);

    EmployeeDTO getEmployee(Integer id);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Integer id);

    void deleteEmployee(Integer id);

}
