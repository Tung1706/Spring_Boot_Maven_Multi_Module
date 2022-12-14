package com.laptrinhjava.dao;

import com.laptrinhjava.EmployeeService;
import com.laptrinhjava.entity.Employee;
import com.laptrinhjava.service.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(convertDTOToDAO(employeeDTO));
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        List<EmployeeDTO> employeeDTO = new ArrayList<EmployeeDTO>();
        for (Employee employee : employeeRepository.findAll()) {
            employeeDTO.add(convertDAOToDTO(employee));
        }
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> searchEmployees(String query) {
        return StreamSupport.stream(employeeRepository.searchEmployees(query).spliterator(),false)
                .map(EmployeeServiceImpl::convertDAOToDTO).collect(Collectors.toList());

    }
//    public List<EmployeeDTO> searchEmployees(String query) {
//        List<EmployeeDTO> employeeDTO = new ArrayList<EmployeeDTO>();
//        for (Employee employee : employeeRepository.searchEmployees(query)) {
//            employeeDTO.add(convertDAOToDTO(employee));
//        }
//        return employeeDTO;
//    }

    @Override
    public EmployeeDTO getEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstname(employee.getFirstname());
        employeeDTO.setLastname(employee.getLastname());
        employeeDTO.setSex(employee.getSex());
        employeeDTO.setDateofbirth(employee.getDateofbirth());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setNumberphone(employee.getNumberphone());
        employeeDTO.setEmail(employee.getEmail());
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Integer id) {
        Employee employee = new Employee();
        if (employee == null) {
            return null;
        }
        employee.setId(id);
        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setSex(employeeDTO.getSex());
        employee.setDateofbirth(employeeDTO.getDateofbirth());
        employee.setAddress(employeeDTO.getAddress());
        employee.setNumberphone(employeeDTO.getNumberphone());
        employee.setEmail(employeeDTO.getEmail());
        employeeRepository.save(employee);
        return employeeDTO;
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);

    }

    public static EmployeeDTO convertDAOToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstname(employee.getFirstname());
        employeeDTO.setLastname(employee.getLastname());
        employeeDTO.setSex(employee.getSex());
        employeeDTO.setDateofbirth(employee.getDateofbirth());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setNumberphone(employee.getNumberphone());
        employeeDTO.setEmail(employee.getEmail());
        return employeeDTO;
    }

    public static Employee convertDTOToDAO(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setSex(employeeDTO.getSex());
        employee.setDateofbirth(employeeDTO.getDateofbirth());
        employee.setAddress(employeeDTO.getAddress());
        employee.setNumberphone(employeeDTO.getNumberphone());
        employee.setEmail(employeeDTO.getEmail());
        return employee;
    }
}
