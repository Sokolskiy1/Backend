package com.example.backendPP.controller;

import com.example.backendPP.entity.Faculty;
import com.example.backendPP.entity.studentEntity;
import com.example.backendPP.exception.CodeMessege;
import com.example.backendPP.model.DepartmentModel;
import com.example.backendPP.model.FacultyModel;
import com.example.backendPP.model.FacultyStudentModel;
import com.example.backendPP.model.Student;
import com.example.backendPP.repository.FacultyRepository;
import com.example.backendPP.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private FacultyRepository facRepo;
    public FacultyController(FacultyRepository facRepo) {
        this.facRepo = facRepo;
    }
    @PostMapping("/reg")
    public ResponseEntity regFaculty(@RequestBody Faculty student){
        try {
            Optional<Faculty> posts = facRepo.findById(student.getId());
            if (posts.isPresent())
            {
                //return ResponseEntity.badRequest().body("Такой студенческий номер уже есть");
                CodeMessege errors = new CodeMessege();
                errors.setError("Wrong data");
                errors.setCode("existence");
                return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
            }
            facRepo.save(student);
            //return ResponseEntity.ok("Пользователь успешно сохранен");
            return new ResponseEntity(FacultyModel.toModel(student), HttpStatus.CREATED);
        } catch (Exception e) {
            //return ResponseEntity.badRequest().body("Произошла ошибка");
            CodeMessege errors = new CodeMessege();
            errors.setError("Wrong data");
            errors.setCode("existence");
            return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/fullfacultys")
    public ResponseEntity getUsers() {
        try {
            //return  ResponseEntity.ok("Сервер работает!");
            Iterable<Faculty>k = facRepo.findAll();
            List<FacultyStudentModel> result1 = new ArrayList<FacultyStudentModel>();
            for (Faculty i : k) {
                result1.add(FacultyStudentModel.toModel(i));
            }
            return  ResponseEntity.ok(result1);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }




}
