package com.microservice.employee_service.service;

import com.microservice.employee_service.model.Employee;

import java.util.List;

public interface iEmployeeService {

    Employee saveEmployee(Employee e);

    Employee findEmployeeByID(int empID);

    List<Employee> findEmployeesByDepID(Integer depID);
}
