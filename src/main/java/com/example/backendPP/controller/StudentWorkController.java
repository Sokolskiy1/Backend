package com.example.backendPP.controller;

import com.example.backendPP.entity.*;
import com.example.backendPP.exception.CodeMessege;
import com.example.backendPP.model.FacultyModel;
import com.example.backendPP.model.StudentWorkModel;
import com.example.backendPP.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/studentworkcontroller")
public class StudentWorkController {

    private StudentWorkRepository studWorkRepo;
    private TypeRepository typeRepo;
    private StudentRepository studRepo;

    public StudentWorkController(StudentWorkRepository studWorkRepo, TypeRepository typeRepo, StudentRepository studRepo) {
        this.studWorkRepo = studWorkRepo;
        this.typeRepo=typeRepo;
        this.studRepo=studRepo;
    }

    @PostMapping("/reg")
    public ResponseEntity registration(@RequestBody student_work student, @RequestParam(value = "type_id", required = false) UUID type_id , @RequestParam(value = "students", required = false) Long students){//, @RequestParam(value = "departament", required = false) UUID departament
        try {
            Optional<type> g = typeRepo.findById(type_id);
            student.setType_id(g.get());
            Optional<studentEntity> s = studRepo.findById(students);
            student.setStudent_card_id(s.get());
            studWorkRepo.save(student);
            //return ResponseEntity.ok("Пользователь успешно сохранен");
            return new ResponseEntity(StudentWorkModel.toModel(student), HttpStatus.CREATED);
        } catch (Exception e) {
            //return ResponseEntity.badRequest().body("Произошла ошибка");
            CodeMessege errors = new CodeMessege();
            errors.setError("Wrong data");
            errors.setCode("existence");
            return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/fullStudWork")
    public ResponseEntity getUsers() {
        try {
            Iterable<student_work> k = studWorkRepo.findAll();
            List<StudentWorkModel> result1 = new ArrayList<StudentWorkModel>();
            k.forEach( StudentWorkModel::toModel);
            for (student_work i : k) {
                result1.add(StudentWorkModel.toModel(i));
            }
            return  ResponseEntity.ok(result1);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
