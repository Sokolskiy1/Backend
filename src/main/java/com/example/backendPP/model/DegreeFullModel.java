package com.example.backendPP.model;

import com.example.backendPP.entity.Degree_of_education;
import com.example.backendPP.entity.studentEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DegreeFullModel {
    private UUID degree_of_education_id;

    private String type_degree;

    private int year_of_graduation;
    private List<StudentModelToFaculty> student;

    public static DegreeFullModel toModel(Degree_of_education entity) {
        DegreeFullModel model = new DegreeFullModel();
        model.setDegree_of_education_id(entity.getDegree_of_education_id()); //set(entity.getUsername());
        model.setType_degree(entity.getType_degree());
        model.setYear_of_graduation(entity.getYear_of_graduation());

        Iterable<studentEntity> k = entity.getStudents();
        List<StudentModelToFaculty> result1 = new ArrayList<StudentModelToFaculty>();
        for (studentEntity i : k) {
            result1.add(StudentModelToFaculty.toModel(i));
        }
        model.setStudent(result1);

        return model;
    }

    public UUID getDegree_of_education_id() {
        return degree_of_education_id;
    }

    public void setDegree_of_education_id(UUID degree_of_education_id) {
        this.degree_of_education_id = degree_of_education_id;
    }

    public String getType_degree() {
        return type_degree;
    }

    public void setType_degree(String type_degree) {
        this.type_degree = type_degree;
    }

    public int getYear_of_graduation() {
        return year_of_graduation;
    }

    public void setYear_of_graduation(int year_of_graduation) {
        this.year_of_graduation = year_of_graduation;
    }

    public List<StudentModelToFaculty> getStudent() {
        return student;
    }

    public void setStudent(List<StudentModelToFaculty> student) {
        this.student = student;
    }
}
