package com.example.backendPP.entity;

import javax.persistence.*;

import java.util.List;
@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //
    private String name;
    private String foundation_date;

    @OneToMany(mappedBy = "facultys")
    private List<studentEntity> todos;

    @OneToMany(mappedBy = "faculty_id")
    private List<departament> departament;

    public List<com.example.backendPP.entity.departament> getDepartament() {
        return departament;
    }

    public void setDepartament(List<com.example.backendPP.entity.departament> departament) {
        this.departament = departament;
    }


    public Faculty(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public List<studentEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<studentEntity> todos) {
        this.todos = todos;
    }
}
