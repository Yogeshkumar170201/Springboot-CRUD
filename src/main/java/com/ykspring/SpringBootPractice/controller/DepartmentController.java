package com.ykspring.SpringBootPractice.controller;

import com.ykspring.SpringBootPractice.entity.Department;
import com.ykspring.SpringBootPractice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById( @PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById( @PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("departments/{id}")
    public Department updateDepartmentById( @RequestBody Department department, @PathVariable("id") Long departmentId){
        return departmentService.updateDepartmentById(department, departmentId);
    }


    @GetMapping("departments/name/{name}")
    public Department fetchDepartmentByName( @PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
