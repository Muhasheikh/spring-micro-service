package com.microservice.employee_service.controller;

import com.microservice.employee_service.model.Employee;
import com.microservice.employee_service.service.iEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final iEmployeeService employeeService;

    public EmployeeController(iEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @RequestMapping(value = "{empID}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeByID(@PathVariable int empID){
        return employeeService.findEmployeeByID(empID);
    }
    @GetMapping(value="/all/{depID}")
    public List<Employee> findEmployeesByDepID(@PathVariable Integer depID){
        LOGGER.info("Inside the controller [{}]",depID);
        return employeeService.findEmployeesByDepID(depID);
    }
}
