package com.example.backendPP.controller;

import com.example.backendPP.entity.studentEntity;
import com.example.backendPP.repository.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class Controller {
    private final UserRepo userRepo;

    public Controller(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody studentEntity student){
        try {
            //userRepo.findByStudent_card_id(student.getStudent_card_id());
            //if (userRepo.findById(student.getStudent_card_id())!=null)
            //userRepo.findByStudent_card_id(student.getStudent_card_id());
           //if (userRepo..findByStudent_card_id(student.getStudent_card_id())
          //  {
          //      return ResponseEntity.badRequest().body("Такой студенческий номер уже есть");
          //  }
            Optional<studentEntity> posts = userRepo.findById(student.getStudent_card_id());
            if (posts.isPresent())
            {
                return ResponseEntity.badRequest().body("Такой студенческий номер уже есть");}
            //userService.registration(user);
            userRepo.save(student);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        //} //catch (UserAlreadyExistException e) {
            //return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/fullstudent")
    public ResponseEntity getUsers() {
        try {
            //return  ResponseEntity.ok("Сервер работает!");
            return  ResponseEntity.ok(userRepo.findAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
//https://stackoverflow.com/questions/63222401/how-to-connect-postgresql-in-gradle-project