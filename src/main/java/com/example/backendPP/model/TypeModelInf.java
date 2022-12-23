package com.example.backendPP.model;

import com.example.backendPP.entity.type;

import java.util.UUID;

public class TypeModelInf {
    private UUID type_id;
    private String name;

    public static TypeModelInf toModel(type entity) {
        TypeModelInf model = new TypeModelInf();

        model.setName(entity.getName());
        model.setType_id(entity.getType_id());
        return model;
    }

    public UUID getType_id() {
        return type_id;
    }

    public void setType_id(UUID type_id) {
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
