package com.microservice.department_service.controller;

import com.microservice.department_service.config.EmployeeClient;
import com.microservice.department_service.model.Department;
import com.microservice.department_service.service.iDepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/departments")
public class DepartmentController {

    private final iDepartmentService iDepartmentService;

    private final EmployeeClient employeeClient;

    public DepartmentController(iDepartmentService iDepartmentService, EmployeeClient employeeClient) {
        this.iDepartmentService = iDepartmentService;
        this.employeeClient = employeeClient;
    }


    @PostMapping
    public Department saveDepartment(@RequestBody Department department){
        return iDepartmentService.saveDepartment(department);
    }

    @GetMapping("/{depID}")
    public Department findDepartmentByID(@PathVariable int depID){
        return iDepartmentService.findDepartmentByID(depID);
    }

    @GetMapping("/findAll")
    public List<Department> findAllDepartment(){
        return iDepartmentService.findAllDepartments();
    }

    @GetMapping("/withEmployees")
    public List<Department> findAllDepartmentwithEmployees(){

        List<Department> departments= iDepartmentService.findAllDepartments();

        departments.forEach(d -> d.setEmployee(employeeClient.
                findEmployeesByDepID(d.getDepartmentID())));

        return departments;
    }
}
