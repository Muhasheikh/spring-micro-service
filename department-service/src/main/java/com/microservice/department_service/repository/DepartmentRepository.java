package com.microservice.department_service.repository;


import com.microservice.department_service.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private List<Department> departmentList = new ArrayList<>();

    public Department save(Department department) {
        departmentList.add(department);
        return department;
    }

    public List<Department> findAllDepartment() {
            return departmentList;
    }


    public Department findDepartmentByID(int deptID) {
        return departmentList.stream().filter(department -> department.getDepartmentID()==deptID)
                .findFirst()
                .orElse(null);
    }
}
