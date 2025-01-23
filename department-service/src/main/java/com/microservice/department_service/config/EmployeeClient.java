package com.microservice.department_service.config;

import com.microservice.department_service.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange(value="employee/all/{depID}")
    public List<Employee> findEmployeesByDepID(@PathVariable Integer depID);

}
