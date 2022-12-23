package com.example.backendPP.model;

import com.example.backendPP.entity.studentEntity;

public class StudentModelToFaculty {
    private Long student_card_id;
    private String name;
    private String surname;
    private String patronymic;
    private FacultyModel facultys;

    public static StudentModelToFaculty toModel(studentEntity entity) {
        StudentModelToFaculty model = new StudentModelToFaculty();
        model.setStudent_card_id(entity.getStudent_card_id()); //set(entity.getUsername());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setPatronymic(entity.getPatronymic());
        //model.setFacultys(new Faculty());
        //if (entity.getFacultys()!=null)
        //  model.setFacultys(entity.getFacultys());
        //if (entity.getFacultys()!=null)
            //model.setFacultys(FacultyModel.toModel(entity.getFacultys()));
        //else
           // model.setFacultys(FacultyModel.toModel());
        //   else
        //     model.setFacultys(new Faculty());
        // model.setFacultys(entity.getFacultys());//setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }
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

    public FacultyModel getFacultys() {
        return facultys;
    }

    public void setFacultys(FacultyModel facultys) {
        this.facultys = facultys;
    }


    public StudentModelToFaculty() {
    }
}
