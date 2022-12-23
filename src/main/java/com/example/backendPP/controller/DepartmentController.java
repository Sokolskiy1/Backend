package com.example.backendPP.controller;

import com.example.backendPP.entity.*;
import com.example.backendPP.exception.CodeMessege;
import com.example.backendPP.model.DegreeModel;
import com.example.backendPP.model.DepartmentModel;
import com.example.backendPP.model.Student;
import com.example.backendPP.model.TeacherModel;
import com.example.backendPP.repository.DepartmentRepository;
import com.example.backendPP.repository.FacultyRepository;
import com.example.backendPP.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/departament")
public class DepartmentController {

    private DepartmentRepository depoRepo;
    private FacultyRepository facRepo;
    private TeacherRepository teaRepo;

    public DepartmentController(DepartmentRepository depoRepo, FacultyRepository facRepo,TeacherRepository teaRepo) {
        this.depoRepo = depoRepo;
        this.facRepo=facRepo;
        this.teaRepo=teaRepo;
    }

    @PostMapping("/reg")
    public ResponseEntity registration(@RequestBody departament student, @RequestParam(value = "facultys", required = false) Long facultys){
        try {
            Optional<Faculty> g = facRepo.findById(facultys);
            student.setFaculty_id(g.get());
            depoRepo.save(student);
            //return ResponseEntity.ok("Пользователь успешно сохранен");
            return new ResponseEntity(DepartmentModel.toModel(student), HttpStatus.CREATED);
        } catch (Exception e) {
            //return ResponseEntity.badRequest().body("Произошла ошибка");
            CodeMessege errors = new CodeMessege();
            errors.setError("Wrong data");
            errors.setCode("existence");
            return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/fulldepartment")
    public ResponseEntity getUsers() {
        try {
            Iterable<departament> k = depoRepo.findAll();
            List<DepartmentModel> result1 = new ArrayList<DepartmentModel>();
            k.forEach( DepartmentModel::toModel);
            for (departament i : k) {
                result1.add(DepartmentModel.toModel(i));
            }
//            Iterable<teacher> k1 = teaRepo.findAll();
//            //List<DepartmentModel> result1 = new ArrayList<DepartmentModel>();
//            k.forEach( TeacherModel::toModel);
//            for (teacher i : k) {
//                result1.add(DepartmentModel.toModel(i));
//            }
            return  ResponseEntity.ok(result1);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
