package uz.nammqi.lessondown.repositories;

import org.springframework.data.jpa.repository.Query;
import uz.nammqi.lessondown.models.Faculties;

public interface FacultiesInterface {

    Faculties findName(String name);
}
