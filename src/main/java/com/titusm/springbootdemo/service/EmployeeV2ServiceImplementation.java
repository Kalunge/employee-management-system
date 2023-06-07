package com.titusm.springbootdemo.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.titusm.springbootdemo.entity.EmployeeEntity;
import com.titusm.springbootdemo.model.Employee;
import com.titusm.springbootdemo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee save(Employee employee) {

        if(employee.getEmployeeId() == null || employee.getEmail().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }

        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);

        employeeRepository.save(entity);

        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<EmployeeEntity> employeeEntitylist = employeeRepository.findAll();
        List<Employee> employees = employeeEntitylist
                .stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity, employee);
                    return employee;

                })
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public Employee getById(String id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);


        return employee;

    }

    @Override
    public String deleteById(String id) {
        employeeRepository.deleteById(id);
        return "Employee with id " + id +" deleted successfully";
    }
}
