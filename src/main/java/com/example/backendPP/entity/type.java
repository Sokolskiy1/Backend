package com.example.backendPP.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Entity
public class type {
    @Id
    @GeneratedValue(generator = "uuid2")
    @org.hibernate.annotations.Type(type="org.hibernate.type.UUIDCharType")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")

    private UUID type_id;
    private String name;
    @OneToMany(mappedBy = "type_id")
    private List<student_work> todos;

    public UUID getType_id() {
        return type_id;
    }

    public void setType_id(UUID teacher_id) {
        this.type_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<student_work> getTodos() {
        return todos;
    }

    public void setTodos(List<student_work> todos) {
        this.todos = todos;
    }
}
