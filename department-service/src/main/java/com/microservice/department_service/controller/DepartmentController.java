package com.microservice.department_service.controller;

import com.microservice.department_service.model.Department;
import com.microservice.department_service.service.iDepartmentService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/departments")
public class DepartmentController {

    private final iDepartmentService iDepartmentService;

    public DepartmentController(iDepartmentService iDepartmentService) {
        this.iDepartmentService = iDepartmentService;
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
}
