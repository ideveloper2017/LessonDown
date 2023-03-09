package uz.nammqi.lessondown.models;

import jakarta.persistence.*;

@Entity
@Table(name = "faculties")
public class Faculties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String facultet_name;

    private int is_active;

    public Faculties() {
    }

    public Faculties(String facultet_name, int is_active) {
        this.facultet_name = facultet_name;
        this.is_active = is_active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacultet_name() {
        return facultet_name;
    }

    public void setFacultet_name(String facultet_name) {
        this.facultet_name = facultet_name;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }
}