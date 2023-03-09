package uz.nammqi.lessondown.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.nammqi.lessondown.models.Faculties;

public interface FacultiesRepository extends JpaRepository<Faculties, Integer> {
}