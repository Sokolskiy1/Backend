package com.example.backendPP.controller;

import com.example.backendPP.entity.Faculty;
import com.example.backendPP.entity.departament;
import com.example.backendPP.entity.teacher;
import com.example.backendPP.exception.CodeMessege;
import com.example.backendPP.model.DepartmentModel;
import com.example.backendPP.model.StudentWorkModel;
import com.example.backendPP.model.TeacherModel;
import com.example.backendPP.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherRepository teachRepo;
    private DepartmentRepository depRepo;

    public TeacherController(TeacherRepository teachRepo,  DepartmentRepository depRepo) {
        this.teachRepo = teachRepo;
        this.depRepo=depRepo;
    }
    @PostMapping("/reg")
    public ResponseEntity registration(@RequestBody teacher student, @RequestParam(value = "departament", required = false) UUID departament){
        try {
            Optional<departament> g = depRepo.findById(departament);
            student.setDepartament_id(g.get());

            teachRepo.save(student);
            return ResponseEntity.ok("Пользователь успешно сохранен");
            //return new ResponseEntity(TeacherModel.toModel(student), HttpStatus.CREATED);
        } catch (Exception e) {
            //return ResponseEntity.badRequest().body("Произошла ошибка");
            CodeMessege errors = new CodeMessege();
            errors.setError("Wrong data");
            errors.setCode("existence");
            return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/fullteacher")
    public ResponseEntity getUsers() {
        try {
            Iterable<teacher> k = teachRepo.findAll();
            //List<studentEntity> result = new ArrayList<studentEntity>();
            List<TeacherModel> result1 = new ArrayList<TeacherModel>();
            //k.forEach(result::add);
            k.forEach( TeacherModel::toModel);
            for (teacher i : k) {
                result1.add(TeacherModel.toModel(i));
            }
            return  ResponseEntity.ok(result1);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
