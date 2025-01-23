package com.microservice.department_service.service.impl;

import com.microservice.department_service.model.Department;
import com.microservice.department_service.repository.DepartmentRepository;
import com.microservice.department_service.service.iDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements iDepartmentService {

    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }


    public Department saveDepartment(Department department) {
       return  repository.save(department);
    }

    @Override
    public List<Department> findAllDepartments() {
        return repository.findAllDepartment();
    }

    @Override
    public Department findDepartmentByID(int deptID) {
        return repository.findDepartmentByID(deptID);
    }
}
