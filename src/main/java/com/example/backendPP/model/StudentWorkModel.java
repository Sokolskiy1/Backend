package com.example.backendPP.model;

import com.example.backendPP.entity.Faculty;
import com.example.backendPP.entity.student_work;
import com.example.backendPP.entity.teacher;

import java.util.UUID;

public class StudentWorkModel {
    private UUID work_id;
    private String name_work;
    private String assessment;
    private TypeModelInf type_id;
    public static StudentWorkModel toModel(student_work entity) {
        StudentWorkModel model = new StudentWorkModel();
        //model.setStudent_card_id(entity.getStudent_card_id()); //set(entity.getUsername());
        model.setWork_id(entity.getWork_id());
        model.setName_work(entity.getName_work());
        model.setAssessment(entity.getAssessment());
        if (entity.getType_id()!=null)
            model.setType_id(TypeModelInf.toModel(entity.getType_id()));
        return model;
    }
    public StudentWorkModel() {
    }

    public TypeModelInf getType_id() {
        return type_id;
    }

    public void setType_id(TypeModelInf type_id) {
        this.type_id = type_id;
    }

    public UUID getWork_id() {
        return work_id;
    }

    public void setWork_id(UUID work_id) {
        this.work_id = work_id;
    }

    public String getName_work() {
        return name_work;
    }

    public void setName_work(String name_work) {
        this.name_work = name_work;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }
}
