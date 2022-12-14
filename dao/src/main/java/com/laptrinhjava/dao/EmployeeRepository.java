package com.laptrinhjava.dao;

import com.laptrinhjava.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE " +
            "e.firstname LIKE CONCAT('%',:query, '%')" +
            "Or e.lastname LIKE CONCAT('%',:query, '%')" +
            "Or e.address LIKE CONCAT('%', :query, '%')")
    List<Employee> searchEmployees(String query);
}
