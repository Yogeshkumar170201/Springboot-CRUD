package com.ykspring.SpringBootPractice.service;

import com.ykspring.SpringBootPractice.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Department department, Long departmentId);

    public Department fetchDepartmentByName(String departmentName);
}
