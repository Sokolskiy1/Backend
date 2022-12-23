package com.example.backendPP.entity;

import javax.persistence.*;
import java.util.List;

@Entity

public class studentEntity {
    @Id
    private Long student_card_id; //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String surname;
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty facultys;

    @ManyToOne
    @JoinColumn(name = "degree_of_education_id")
    private Degree_of_education degree_of_education_id;

    @ManyToOne
    @JoinColumn(name = "id")
    private departament id;

    @OneToMany(mappedBy = "student_card_id")
    private List<student_work> work;

    public List<student_work> getWork() {
        return work;
    }

    public void setWork(List<student_work> work) {
        this.work = work;
    }

    public studentEntity(){}

    public departament getId() {
        return id;
    }

    public void setId(departament id) {
        this.id = id;
    }

    public Long getStudent_card_id() {
        return student_card_id;
    }



    public void setStudent_card_id(Long student_card_id) {
        this.student_card_id = student_card_id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Faculty getFacultys() {
        return facultys;
    }

    public void setFacultys(Faculty facultys) {
        this.facultys = facultys;
    }

    public Degree_of_education getDegree_of_education_id() {
        return degree_of_education_id;
    }

    public void setDegree_of_education_id(Degree_of_education degree_of_education_id) {
        this.degree_of_education_id = degree_of_education_id;
    }

    public studentEntity(Long student_card_id, String name, String surname, Faculty facultys, String patronymic) {
        this.student_card_id = student_card_id;
        this.name = name;
        this.surname = surname;
        this.facultys = facultys;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public studentEntity(Faculty facultys) {

        this.facultys = facultys;
    }


    public studentEntity(String name, Faculty facultys) {
        this.name = name;
        this.facultys = facultys;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

}
