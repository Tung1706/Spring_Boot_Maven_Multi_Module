package com.laptrinhjava.service;

import lombok.Data;

import java.time.Instant;

@Data
public class EmployeeDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String sex;
    private Instant dateofbirth;
    private String address;
    private String numberphone;
    private String email;
}
