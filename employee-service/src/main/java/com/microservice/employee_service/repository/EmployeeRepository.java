package com.microservice.employee_service.repository;

import com.microservice.employee_service.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepository.class);

    List<Employee> employeeList = new ArrayList<>();
    public Employee saveEmployee(Employee e) {
         employeeList.add(e);
         return e;
    }

    public Employee findEmployeeByID(int empID) {

        return employeeList.stream().filter(e -> e.empID()==empID)
                .findFirst().orElseThrow();
    }

    public List<Employee> findEmployeeByDeptID(Integer depID) {

        LOGGER.info("Inside the findEmployeeByDeptID [{}] ",depID);

        return employeeList.stream().filter(employee -> employee.depID().equals(depID)).toList();
    }
}
