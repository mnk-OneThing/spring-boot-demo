package com.mnk.springbootdemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tbl_employee")
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    private String empId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String department;
}
