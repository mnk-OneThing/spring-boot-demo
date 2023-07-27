package com.mnk.springbootdemo.model;

import lombok.Data;

@Data
public class Employee {
    private String empId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String department;
}
