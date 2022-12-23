package com.example.backendPP.model;

import com.example.backendPP.entity.Faculty;
import com.example.backendPP.entity.departament;
import com.example.backendPP.entity.studentEntity;
import com.example.backendPP.entity.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepartmentModel {
    private UUID id;
    private String name;
    private String foundation_date;

    private FacultyModel facMod;

    private List<StudentModelToFaculty> student;

    private List<TeacherModel> teachers;

    public static DepartmentModel toModel(departament entity) {
        DepartmentModel model = new DepartmentModel();
        model.setId(entity.getId()); //set(entity.getUsername());
        model.setName(entity.getName());
        model.setFoundation_date(entity.getFoundation_date());
        if (entity.getFaculty_id()!=null)
            model.setFacMod(FacultyModel.toModel(entity.getFaculty_id()));

        Iterable<studentEntity> k = entity.getStudents();
        List<StudentModelToFaculty> result1 = new ArrayList<StudentModelToFaculty>();
        for (studentEntity i : k) {
            result1.add(StudentModelToFaculty.toModel(i));
        }
        model.setStudent(result1);

        Iterable<teacher> k1 = entity.getTeachers();
        List<TeacherModel> result2 = new ArrayList<TeacherModel>();
        for (teacher i : k1) {
            result2.add(TeacherModel.toModel(i));
        }
        model.setTeacher(result2);
        return model;
    }

    public List<TeacherModel> getTeacher() {
        return teachers;
    }

    public void setTeacher(List<TeacherModel> teachers) {
        this.teachers = teachers;
    }

    public List<StudentModelToFaculty> getStudent() {
        return student;
    }

    public void setStudent(List<StudentModelToFaculty> student) {
        this.student = student;
    }

    public DepartmentModel() {
    }
    public UUID getId() {
        return id;
    }

    public FacultyModel getFacMod() {
        return facMod;
    }

    public void setFacMod(FacultyModel facMod) {
        this.facMod = facMod;
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
