package com.example.demo.services;

import com.example.demo.entities.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        return department.get();
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
