package com.example.backendPP.model;

import com.example.backendPP.entity.Faculty;
import com.example.backendPP.entity.departament;
import com.example.backendPP.entity.studentEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FacultyStudentModel {
    private Long id; //
    private String name;
    private String foundation_date;

    private List<StudentModelToFaculty> todos;
    private List<DepartmentModel> departaments;

    public static FacultyStudentModel toModel(Faculty entity) {
        FacultyStudentModel model = new FacultyStudentModel();
        model.setId(entity.getId()); //set(entity.getUsername());
        model.setName(entity.getName());
        model.setFoundation_date(entity.getFoundation_date());
        //model.setTodos(entity.getTodos().stream().map(todos::toModel).collect(Collectors.toList()));
        Iterable<studentEntity> k = entity.getTodos();
        List<StudentModelToFaculty> result1 = new ArrayList<StudentModelToFaculty>();
        for (studentEntity i : k) {
            result1.add(StudentModelToFaculty.toModel(i));
        }
        model.setTodos(result1);

        Iterable<departament> k1 = entity.getDepartament();
        List<DepartmentModel> result2 = new ArrayList<DepartmentModel>();
        for (departament i : k1) {
            result2.add(DepartmentModel.toModel(i));
        }
        model.setDepartaments(result2);
        // model.setFacultys(entity.getFacultys());//setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public FacultyStudentModel() {
    }

    public List<DepartmentModel> getDepartaments() {
        return departaments;
    }

    public void setDepartaments(List<DepartmentModel> departaments) {
        this.departaments = departaments;
    }

    public List<StudentModelToFaculty> getTodos() {
        return todos;
    }

    public void setTodos(List<StudentModelToFaculty> todos) {
        this.todos = todos;
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
