package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department newDep = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) && !department.getDepartmentName().equalsIgnoreCase(""))
            newDep.setDepartmentName(department.getDepartmentName());

        if (Objects.nonNull(department.getDepartmentAddress()) && !department.getDepartmentAddress().equalsIgnoreCase(""))
            newDep.setDepartmentAddress(department.getDepartmentAddress());

        if (Objects.nonNull(department.getDepartmentCode()) && !department.getDepartmentCode().equalsIgnoreCase(""))
            newDep.setDepartmentCode(department.getDepartmentCode());
        return departmentRepository.save(newDep);
    }
}
