package uz.nammqi.lessondown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uz.nammqi.lessondown.services.DepartmentService;

@SpringBootApplication
public class LessonDownApplication {

    @Autowired
    DepartmentService departmentService;



    public static void main(String[] args) {
        SpringApplication.run(LessonDownApplication.class, args);

    }

}
