package com.laptrinhjava.service;

import com.laptrinhjava.EmployeeService;

import java.util.List;
import java.util.Optional;

public class Service {

    private EmployeeService employeeService;

    public Service(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Optional<EmployeeDTO> employeeDTO1 = Optional.of(employeeDTO);
        employeeService.createEmployee(employeeDTO);
        return employeeDTO;
    }

    public List<EmployeeDTO> getEmployees() {
        return employeeService.getEmployees();
    }

    public List<EmployeeDTO> searchEmployees(String query) {
        return employeeService.searchEmployees(query);
    }

    public EmployeeDTO getEmployee(Integer id) {
        return employeeService.getEmployee(id);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Integer id) {
        return employeeService.updateEmployee(employeeDTO, id);
    }

    public void delete(Integer id) {
        employeeService.deleteEmployee(id);
    }
}
