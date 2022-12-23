package com.example.backendPP.model;

import com.example.backendPP.entity.departament;
import com.example.backendPP.entity.studentEntity;
import com.example.backendPP.entity.teacher;

import java.util.UUID;

public class TeacherModel {
    private UUID teacher_id;
    private String surname;

    private String name;

    private String patronymic;

    private DepartmentModel departament_id;
    private String scientific_degree;
    public static TeacherModel toModel(teacher entity) {
        TeacherModel model = new TeacherModel();
        //model.setStudent_card_id(entity.getStudent_card_id()); //set(entity.getUsername());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setPatronymic(entity.getPatronymic());
        model.setTeacher_id(entity.getTeacher_id());
        model.setScientific_degree(entity.getScientific_degree());
        if (entity.getDepartament_id()!=null)
            model.setDepartament_id(DepartmentModel.toModel(entity.getDepartament_id()));
        return model;
    }
    public TeacherModel() {
    }

    public DepartmentModel getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(DepartmentModel departament_id) {
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

    public String getScientific_degree() {
        return scientific_degree;
    }

    public void setScientific_degree(String scientific_degree) {
        this.scientific_degree = scientific_degree;
    }
}
