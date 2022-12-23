package com.example.backendPP.controller;

import com.example.backendPP.entity.departament;
import com.example.backendPP.entity.teacher;
import com.example.backendPP.entity.type;
import com.example.backendPP.model.TeacherModel;
import com.example.backendPP.repository.DepartmentRepository;
import com.example.backendPP.repository.TeacherRepository;
import com.example.backendPP.repository.TypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@RequestMapping("/typecontroller")
public class TypeController {
    private TypeRepository typeRepo;
    public TypeController(TypeRepository typeRepo) {
        this.typeRepo = typeRepo;
    }
    @PostMapping("/reg")
    public ResponseEntity registration(@RequestBody type student){
        try {
            //Optional<com.example.backendPP.entity.departament> g = typeRepo.findById(departament);
            //student.setDepartament_id(g.get());

            typeRepo.save(student);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

//    @GetMapping("/fulltype")
//    public ResponseEntity getUsers() {
//        try {
//            Iterable<teacher> k = teachRepo.findAll();
//            List<TeacherModel> result1 = new ArrayList<TeacherModel>();
//            k.forEach( TeacherModel::toModel);
//            for (teacher i : k) {
//                result1.add(TeacherModel.toModel(i));
//            }
//            return  ResponseEntity.ok(result1);
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }
}
