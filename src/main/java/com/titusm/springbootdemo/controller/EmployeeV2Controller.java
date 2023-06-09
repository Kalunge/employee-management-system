package com.titusm.springbootdemo.controller;

import com.titusm.springbootdemo.model.Employee;
import com.titusm.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("v2/employees")
public class EmployeeV2Controller {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return  employeeService.save(employee);
    }
}
