package uz.nammqi.lessondown.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.nammqi.lessondown.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}