package uz.nammqi.lessondown.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.nammqi.lessondown.models.Faculties;

import java.util.List;

@Repository
public interface FacultiesRepository  extends JpaRepository<Faculties, Integer> {



}