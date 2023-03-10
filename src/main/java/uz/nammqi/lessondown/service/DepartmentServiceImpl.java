package uz.nammqi.lessondown.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.nammqi.lessondown.models.Department;
import uz.nammqi.lessondown.repositories.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository deparmentrepository;
    @Override
    public void add(Department... department) {
//        for (Department dep : department) {
//            if (deparmentrepository.findByDepartment_name(dep.getDepartment_name()) == null) {
//                deparmentrepository.save(dep);
//            }
//        }
    }

    @Override
    public List<Department> getAllDepartment() {
        return deparmentrepository.findAll();
    }
}
