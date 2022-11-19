package com.example.backendPP.entity;

import javax.persistence.*;

@Entity

public class studentEntity {
    @Id
    private Long student_card_id; //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String surname;

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

    public studentEntity(Long student_card_id, String name, String surname, String patronymic) {
        this.student_card_id = student_card_id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public studentEntity() {

    }


    public studentEntity(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }
}
