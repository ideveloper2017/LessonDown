package uz.nammqi.lessondown.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.nammqi.lessondown.models.Faculties;
import uz.nammqi.lessondown.repositories.FacultiesRepository;

@Service
public class FacultiesServiceImpl implements FacultiesService{

    @Autowired
    FacultiesRepository facultiesRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Faculties... faculties) {



        for(Faculties fc: faculties){
            if (facultiesRepository.count()==0) {
                facultiesRepository.save(fc);
            }
        }


    }
}
