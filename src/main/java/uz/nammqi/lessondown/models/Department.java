package uz.nammqi.lessondown.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    private Faculties faculties;
    private String depname;

    public Department() {
    }

    public Department(Faculties faculties, String depname) {
        this.faculties = faculties;
        this.depname = depname;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Faculties getFaculties() {
        return faculties;
    }

    public void setFaculties(Faculties faculties) {
        this.faculties = faculties;
    }

    public String getDepartment_name() {
        return depname;
    }

    public void setDepartment_name(String department_name) {
        this.depname = department_name;
    }
}