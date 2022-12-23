package com.example.backendPP.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MessegeNewStudentNice {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    // private LocalDateTime timestamp;
    //private int status;
    //private String error;
    private Long student_card_id; //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String surname;
    private String patronymic;

    public Long getStudent_card_id() {
        return student_card_id;
    }

    public void setStudent_card_id(Long student_card_id) {
        this.student_card_id = student_card_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
