package com.titusm.springbootdemo.service;

import com.titusm.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);

    List<Employee> getAll();

    Employee getById(String id);
}
