package com.example.backendPP.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
public class teacher {
    @Id
    @GeneratedValue(generator = "uuid2")
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")

    private UUID teacher_id;
    private String surname;

    private String name;

    private String patronymic;
    private String scientific_degree;

    @ManyToOne
    @JoinColumn(name = "departament_id")
    private departament departament_id;

    @OneToMany(mappedBy = "student_card_id")
    private List<student_work> work_to_student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public teacher(UUID teacher_id, String surname, String scientific_degree, departament departament_id) {
        this.teacher_id = teacher_id;
        this.surname = surname;
        this.scientific_degree = scientific_degree;
        this.departament_id = departament_id;
    }
    public teacher( String surname, String scientific_degree, departament departament_id) {
        this.teacher_id = teacher_id;
        this.surname = surname;
        this.scientific_degree = scientific_degree;
        this.departament_id = departament_id;
    }

    public teacher() {

    }



    public departament getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(departament departament_id) {
        this.departament_id = departament_id;
    }

    public UUID getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(UUID teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getScientific_degree() {
        return scientific_degree;
    }

    public void setScientific_degree(String scientific_degree) {
        this.scientific_degree = scientific_degree;
    }
}
