package com.example.demo.controllers;

import com.example.demo.entities.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.services.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("POST: saveDepartment");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartment(){
        LOGGER.info("GET : fetchDepartment()");
        return departmentService.fetchDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("GET : fetchDepartmentById");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("GET : fetchDepartmentByName");
        return departmentService.fetchDepartmentByName(departmentName);

    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("DELETE : deleteDepartmentById");

        String depName = departmentService.fetchDepartmentById(departmentId).getDepartmentName();
        departmentService.deleteDepartmentById(departmentId);
        return String.format(depName + " Deleted Successfully");
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,
                                           @RequestBody Department department){
        LOGGER.info("PUT : updateDepartmentById");

        return departmentService.updateDepartmentById(departmentId, department);

    }
}
