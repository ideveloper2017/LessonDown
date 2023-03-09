package uz.nammqi.lessondown.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nammqi.lessondown.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}