package com.microservice.department_service.service;

import com.microservice.department_service.model.Department;

import java.util.List;

public interface iDepartmentService {

    Department saveDepartment(Department department);
    List<Department> findAllDepartments();
    Department findDepartmentByID(int deptID);
}
