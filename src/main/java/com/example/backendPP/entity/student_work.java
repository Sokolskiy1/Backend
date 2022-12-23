package com.example.backendPP.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;
@Entity
public class student_work {
    @Id
    @GeneratedValue(generator = "uuid2")
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")

    private UUID work_id;
    private String name_work;
    private String assessment;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private type type_id;

    @ManyToOne
    @JoinColumn(name = "student_card_id")
    private studentEntity student_card_id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private teacher teacher_id;

    public UUID getWork_id() {
        return work_id;
    }

    public studentEntity getStudent_card_id() {
        return student_card_id;
    }

    public void setStudent_card_id(studentEntity student_card_id) {
        this.student_card_id = student_card_id;
    }

    public teacher getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(teacher teacher_id) {
        this.teacher_id = teacher_id;
    }

    public type getType_id() {
        return type_id;
    }

    public void setType_id(type type_id) {
        this.type_id = type_id;
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
