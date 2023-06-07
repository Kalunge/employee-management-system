package com.titusm.springbootdemo.service;

import com.titusm.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImplementation implements  EmployeeService{

    List<Employee> employees = new ArrayList<>();




    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmail().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }

        employees.add(employee);
        return employee;
    }
}
