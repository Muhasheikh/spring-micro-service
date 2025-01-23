package com.microservice.employee_service.service.impl;

import com.microservice.employee_service.model.Employee;
import com.microservice.employee_service.repository.EmployeeRepository;
import com.microservice.employee_service.service.iEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements iEmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(Employee e) {
        return repository.saveEmployee(e);
    }

    @Override
    public Employee findEmployeeByID(int empID) {

        return repository.findEmployeeByID(empID);
    }

    @Override
    public List<Employee> findEmployeesByDepID(Integer depID) {
        return repository.findEmployeeByDeptID(depID);
    }
}
