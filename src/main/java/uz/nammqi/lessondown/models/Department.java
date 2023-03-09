package uz.nammqi.lessondown.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    private Faculties faculties;

    public Department() {
    }

    public Department(Faculties faculties, String department_name) {
        this.faculties = faculties;
        this.department_name = department_name;
    }

    private String department_name;

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
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}