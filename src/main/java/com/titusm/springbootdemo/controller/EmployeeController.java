package com.titusm.springbootdemo.controller;

import com.titusm.springbootdemo.model.Employee;
import com.titusm.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return  employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id) {
        return employeeService.deleteById(id);
    }


}
