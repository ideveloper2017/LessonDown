package uz.nammqi.lessondown.service;

import uz.nammqi.lessondown.models.Department;

import java.util.List;


public interface DepartmentService {
    void add(Department... department);
    List<Department> getAllDepartment();
}