package com.example.backendPP.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Degree_of_education {
    @Id
    @GeneratedValue(generator = "uuid2")
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")

    private UUID degree_of_education_id;

    private String type_degree;

    private int year_of_graduation;

    @OneToMany(mappedBy = "degree_of_education_id")
    private List<studentEntity> students;

    public Degree_of_education(UUID degree_of_education_id, String type_degree, int year_of_graduation) {
        this.degree_of_education_id = degree_of_education_id;
        this.type_degree = type_degree;
        this.year_of_graduation = year_of_graduation;
    }

    public Degree_of_education(String type_degree, int year_of_graduation) {
        //degree_of_education_id;
        this.type_degree = type_degree;
        this.year_of_graduation = year_of_graduation;
    }



    public Degree_of_education() {

    }

    public List<studentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<studentEntity> students) {
        this.students = students;
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
}
