package com.example.backendPP.entity;

import javax.persistence.*;

@Entity

public class studentEntity {
    @Id
    private Long student_card_id; //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String surname;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty facultys;

    public studentEntity(){}

    public Long getStudent_card_id() {
        return student_card_id;
    }

    private String patronymic;

    public void setStudent_card_id(Long student_card_id) {
        this.student_card_id = student_card_id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
