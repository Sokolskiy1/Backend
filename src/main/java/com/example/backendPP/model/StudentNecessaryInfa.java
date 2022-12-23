package com.example.backendPP.model;

import com.example.backendPP.entity.studentEntity;

import java.util.UUID;

public class StudentNecessaryInfa {
    private Long student_card_id;
    private String name;
    private String surname;
    private String patronymic;
    //private FacultyModel facultys;
    private String facultysname;
    private Long facultys_id;

    //private DegreeModel degree;
    private String degreename;
    private UUID degree_id;

    //private DepartmentModel departament ;
    private String departamentname;
    private UUID departament_id;

    public static StudentNecessaryInfa toModel(studentEntity entity) {
        StudentNecessaryInfa model = new StudentNecessaryInfa();
        model.setStudent_card_id(entity.getStudent_card_id()); //set(entity.getUsername());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setPatronymic(entity.getPatronymic());
        if (entity.getDegree_of_education_id()!=null) {
            //model.setDegree(DegreeModel.toModel(entity.getDegree_of_education_id()));
            model.setDegree_id(entity.getDegree_of_education_id().getDegree_of_education_id());
            model.setDegreename(entity.getDegree_of_education_id().getType_degree());
        }
        //if (entity.getDegree_of_education_id()!=null)
        //    model.setFacultysname(entity.getDegree_of_education_id().getType_degree());
        //else
        // model.setDegree(DegreeModel.toModel());
        //model.setFacultys(new Faculty());
        //if (entity.getFacultys()!=null)
        //  model.setFacultys(entity.getFacultys());
        if (entity.getFacultys()!=null){
            //model.setFacultys(FacultyModel.toModel(entity.getFacultys()));
            model.setFacultys_id(entity.getFacultys().getId());
            model.setFacultysname(entity.getFacultys().getName());}
        //else
            //model.setFacultys(FacultyModel.toModel());
        if (entity.getId()!=null){
            //model.setDepartament(DepartmentModel.toModel(entity.getId()));
            model.setDepartament_id(entity.getId().getId());
            model.setDepartamentname(entity.getId().getName());

        }
        //   else
        //     model.setFacultys(new Faculty());
        // model.setFacultys(entity.getFacultys());//setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public UUID getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(UUID departament_id) {
        this.departament_id = departament_id;
    }

    public Long getStudent_card_id() {
        return student_card_id;
    }

    public String getFacultysname() {
        return facultysname;
    }

    public void setFacultysname(String facultysname) {
        this.facultysname = facultysname;
    }

    public Long getFacultys_id() {
        return facultys_id;
    }

    public void setFacultys_id(Long facultys_id) {
        this.facultys_id = facultys_id;
    }

    public String getDegreename() {
        return degreename;
    }

    public void setDegreename(String degreename) {
        this.degreename = degreename;
    }

    public UUID getDegree_id() {
        return degree_id;
    }

    public void setDegree_id(UUID degree_id) {
        this.degree_id = degree_id;
    }

    public String getDepartamentname() {
        return departamentname;
    }

    public void setDepartamentname(String departamentname) {
        this.departamentname = departamentname;
    }
//    public DepartmentModel getDepartament() {
//        return departament;
//    }
//
//    public void setDepartament(DepartmentModel departament) {
//        this.departament = departament;
//    }
//
//    public Long getStudent_card_id() {
//        return student_card_id;
//    }
//
//    public DegreeModel getDegree() {
//        return degree;
//    }
//
//    public void setDegree(DegreeModel degree) {
//        this.degree = degree;
//    }

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

//    public FacultyModel getFacultys() {
//        return facultys;
//    }
//
//    public void setFacultys(FacultyModel facultys) {
//        this.facultys = facultys;
//    }

    public StudentNecessaryInfa() {
    }
}
