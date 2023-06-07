package com.titusm.springbootdemo.service;

import com.titusm.springbootdemo.exceptions.EmployeeNotFoundException;
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

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee getById(String id) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));
    }

    @Override
    public String deleteById(String id) {
        Employee epmloyee = employees.stream()
                .filter(employee -> employee.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();

        employees.remove(epmloyee);

        return "Employee with id " + id +" deleted successfully";

    }


}
