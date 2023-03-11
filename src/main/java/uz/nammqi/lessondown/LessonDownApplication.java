package uz.nammqi.lessondown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uz.nammqi.lessondown.models.Department;
import uz.nammqi.lessondown.models.Faculties;
import uz.nammqi.lessondown.service.DepartmentService;
import uz.nammqi.lessondown.service.FacultiesService;

@SpringBootApplication
//@EnableSwagger2
public class LessonDownApplication implements CommandLineRunner {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    FacultiesService facultiesService;


    public static void main(String[] args) {
        SpringApplication.run(LessonDownApplication.class, args);

    }



    @Override
    public void run(String... args) throws Exception {
//        Faculties faculties=new Faculties();
//        faculties.setIs_active(1);
//        faculties.setFacultet_name("Муҳандислик коммуникациялари");
//        facultiesService.save(
//                new Faculties("Муҳандислик коммуникациялари",1),
//                new Faculties("Қурилиш",1),
//                new Faculties("Саноатни ахборотлаштириш",1),
//                new Faculties("Машинасозлик",1),
//                new Faculties("Транспорт",1),
//                new Faculties("Энергетика ва меҳнат мухофазаси",1),
//                new Faculties("Иқтисодиёт ва бошқарув ",1));
//
//        departmentService.add(new Department(new Faculties("Муҳандислик коммуникациялари",1),"Муҳандислик коммуникациялари қурилиши ва монтажи"));

    }
}
