package com.mnk.springbootdemo.service;

import com.mnk.springbootdemo.exception.EmployeeNotFoundException;
import com.mnk.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getEmpId() == null || employee.getEmpId().isEmpty()) {
            employee.setEmpId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeList.stream().
                filter(e -> e.getEmpId().equals(id)).
                findFirst().orElseThrow(() -> new EmployeeNotFoundException("Employee not found with Id: " + id));

    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = employeeList.stream().filter(e -> e.getEmpId().equals(id)).findFirst().get();
        employeeList.remove(employee);
        return "Employee deleted with the id :" + id;
    }
}
