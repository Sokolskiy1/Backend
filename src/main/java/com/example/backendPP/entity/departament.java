package com.example.backendPP.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
public class departament {
    @Id
    @GeneratedValue(generator = "uuid2")
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")

    private UUID id;
    private String name;
    private String foundation_date;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty_id;

    @OneToMany(mappedBy = "id")
    private List<studentEntity> students;
    @OneToMany(mappedBy = "departament_id")
    private List<teacher> teachers;
//    @ManyToOne
//    @JoinColumn(name = "departament_id")
//    private teacher teachers;

    public List<studentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<studentEntity> students) {
        this.students = students;
    }

    public List<teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<teacher> teachers) {
        this.teachers = teachers;
    }

    public UUID getId() {
        return id;
    }

    public Faculty getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(Faculty faculty_id) {
        this.faculty_id = faculty_id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoundation_date() {
        return foundation_date;
    }

    public void setFoundation_date(String foundation_date) {
        this.foundation_date = foundation_date;
    }
}
