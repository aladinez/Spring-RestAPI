package com.example.demo.services;

import com.example.demo.entities.Department;
import com.example.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public Department fetchDepartmentByName(String departmentName);

    void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);
}
