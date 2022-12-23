package com.example.backendPP.model;

import com.example.backendPP.entity.Faculty;
import com.example.backendPP.entity.departament;
import com.example.backendPP.entity.studentEntity;
import com.example.backendPP.entity.student_work;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private Long student_card_id;
    private String name;
    private String surname;
    private String patronymic;
    private FacultyModel facultys;

    private DegreeModel degree;

    private DepartmentModel departament;
    private List<student_work> work;
    public static Student toModel(studentEntity entity) {
        Student model = new Student();
        model.setStudent_card_id(entity.getStudent_card_id()); //set(entity.getUsername());
        model.setName(entity.getName());
        model.setSurname(entity.getSurname());
        model.setPatronymic(entity.getPatronymic());
        if (entity.getDegree_of_education_id()!=null)
            model.setDegree(DegreeModel.toModel(entity.getDegree_of_education_id()));
        //else
           // model.setDegree(DegreeModel.toModel());
        //model.setFacultys(new Faculty());
        //if (entity.getFacultys()!=null)
         //  model.setFacultys(entity.getFacultys());
        if (entity.getFacultys()!=null)
            model.setFacultys(FacultyModel.toModel(entity.getFacultys()));
        else
            model.setFacultys(FacultyModel.toModel());
        if (entity.getId()!=null)
            model.setDepartament(DepartmentModel.toModel(entity.getId()));
        //if (entity.getWork()!=null)
          //  model.setWork(StudentWorkModel.toModel(entity.getWork()));

        //if (entity.getWork().isEmpty()){
            Iterable<student_work> k1 = entity.getWork();
            List<StudentWorkModel> result2 = new ArrayList<StudentWorkModel>();
            for (student_work i : k1) {
              result2.add(StudentWorkModel.toModel(i));
             }
        //}

     //   else
       //     model.setFacultys(new Faculty());
       // model.setFacultys(entity.getFacultys());//setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public List<student_work> getWork() {
        return work;
    }

    public void setWork(List<student_work> work) {
        this.work = work;
    }

    public DepartmentModel getDepartament() {
        return departament;
    }

    public void setDepartament(DepartmentModel departament) {
        this.departament = departament;
    }

    public Long getStudent_card_id() {
        return student_card_id;
    }

    public DegreeModel getDegree() {
        return degree;
    }

    public void setDegree(DegreeModel degree) {
        this.degree = degree;
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

    public Student() {
    }
}
