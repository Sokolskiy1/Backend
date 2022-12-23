package com.example.backendPP.model;

import com.example.backendPP.entity.Faculty;
import com.example.backendPP.entity.studentEntity;

public class FacultyModel {
    private Long id; //
    private String name;
    private String foundation_date;

    public FacultyModel() {
    }

    public static FacultyModel toModel(Faculty entity) {
        FacultyModel model = new FacultyModel();
        model.setId(entity.getId()); //set(entity.getUsername());
        model.setName(entity.getName());
        model.setFoundation_date(entity.getFoundation_date());

        //model.setFacultys(new Faculty());
        //if (entity.getFacultys()!=null)
        //  model.setFacultys(entity.getFacultys());
        //   else
        //     model.setFacultys(new Faculty());
        // model.setFacultys(entity.getFacultys());//setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }
    public static FacultyModel toModel() {
        FacultyModel model = new FacultyModel();
        //model.setId(entity.getId()); //set(entity.getUsername());
        model.setName("нетк");
        model.setFoundation_date("нетк");
        //model.setFacultys(new Faculty());
        //if (entity.getFacultys()!=null)
        //  model.setFacultys(entity.getFacultys());
        //   else
        //     model.setFacultys(new Faculty());
        // model.setFacultys(entity.getFacultys());//setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

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
}
