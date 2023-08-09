package com.ykspring.SpringBootPractice.controller;

import com.ykspring.SpringBootPractice.entity.Department;
import com.ykspring.SpringBootPractice.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment( @Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        LOGGER.info("Inside getDepartment of DepartmentController");
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById( @PathVariable("id") Long departmentId){
        LOGGER.info("Inside getDepartmentById of DepartmentController");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById( @PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("departments/{id}")
    public Department updateDepartmentById( @Valid @RequestBody Department department, @PathVariable("id") Long departmentId){
        LOGGER.info("Inside updateDepartmentById of DepartmentController");
        return departmentService.updateDepartmentById(department, departmentId);
    }


    @GetMapping("departments/name/{name}")
    public Department fetchDepartmentByName( @PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
