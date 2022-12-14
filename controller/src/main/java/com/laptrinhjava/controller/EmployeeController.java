package com.laptrinhjava.controller;

import com.laptrinhjava.service.EmployeeDTO;
import com.laptrinhjava.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private Service service;

    //http://localhost:8080/api/employees/
    @PostMapping("/")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<EmployeeDTO>(service.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    //http://localhost:8080/api/employees/
    @GetMapping("/")
    public List<EmployeeDTO> getEmployees() {
        return service.getEmployees();
    }

    //http://localhost:8080/api/employees/search?query=...
    @GetMapping("/search")
    public ResponseEntity<List<EmployeeDTO>> searchEmployees(@RequestParam("query") String query) {
        return ResponseEntity.ok(service.searchEmployees(query));
    }

    //http://localhost:8080/api/employees/id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer id) {
        return new ResponseEntity<EmployeeDTO>(service.getEmployee(id), HttpStatus.OK);
    }

    //http://localhost:8080/api/employees/id
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<EmployeeDTO>(service.updateEmployee(employeeDTO, id), HttpStatus.OK);
    }

    //http://localhost:8080/api/employees/id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
    }

}
