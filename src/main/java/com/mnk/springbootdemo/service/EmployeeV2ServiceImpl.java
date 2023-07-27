package com.mnk.springbootdemo.service;

import com.mnk.springbootdemo.entity.EmployeeEntity;
import com.mnk.springbootdemo.model.Employee;
import com.mnk.springbootdemo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {

        if (employee.getEmpId() == null || employee.getEmpId().isEmpty()) {
            employee.setEmpId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        employeeEntities.forEach(e -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(e, employee);
            employeeList.add(employee);
        });
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee deleted with the id :" + id;
    }
}
