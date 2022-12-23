package com.example.backendPP.controller;

import com.example.backendPP.entity.Degree_of_education;

import com.example.backendPP.entity.studentEntity;
import com.example.backendPP.exception.CodeMessege;
import com.example.backendPP.model.DegreeFullModel;
import com.example.backendPP.model.DegreeModel;
import com.example.backendPP.model.Student;
import com.example.backendPP.model.StudentNecessaryInfa;
import com.example.backendPP.repository.DegreeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/degree")
public class DegreeEdController {

    private DegreeRepository degreeRepo;
    public DegreeEdController(DegreeRepository degreeRepo) {
        this.degreeRepo = degreeRepo;
    }
    @PostMapping("/reg")
    public ResponseEntity regDegree(@RequestBody Degree_of_education student){//(@RequestBody(value = "type_degree") String type_degree,@RequestParam(value = "year_of_graduation") String year_of_graduation)
        try {//
            degreeRepo.save(student);
            return new ResponseEntity(DegreeModel.toModel(student), HttpStatus.CREATED);
            //return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (Exception e) {
            CodeMessege errors = new CodeMessege();
            errors.setError("Wrong data");
            errors.setCode("existence");
            return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
            //return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/lol")
    public ResponseEntity testngrok(@RequestParam(value = "facultys", required = false) String facultys){//(@RequestBody(value = "type_degree") String type_degree,@RequestParam(value = "year_of_graduation") String year_of_graduation)
        try {//

            //degreeRepo.save(student);

            return ResponseEntity.ok(facultys);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/fulldegree")
    public ResponseEntity getUsers() {
        try {
            Iterable<Degree_of_education> k = degreeRepo.findAll();
            List<DegreeFullModel> result1 = new ArrayList<DegreeFullModel>();
            k.forEach( DegreeFullModel::toModel);
            for (Degree_of_education i : k) {
                result1.add(DegreeFullModel.toModel(i));
            }
            return  ResponseEntity.ok(result1);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/getdegree/")
    public ResponseEntity getDegree(@RequestParam(value = "uuid") UUID uuid) {
        try {
            //return  ResponseEntity.ok("Сервер работает!");
            Optional<Degree_of_education> g = degreeRepo.findById(uuid);//findByDegree_of_education_id(uuid)

            //return  ResponseEntity.ok("Тип обучения " + g.get().getType_degree() +" Лет обучаться "+ g.get().getYear_of_graduation() );//degreeRepo.findByDegree_of_education_id(uuid).get()
            CodeMessege errors = new CodeMessege();
            errors.setError("Not info to this degree");
            errors.setCode("existence");
            if (g!=null)
                return  ResponseEntity.ok(DegreeModel.toModel(g.get()) );
            return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
        }catch (Exception e){
            //return ResponseEntity.badRequest().body("Произошла ошибка");
            CodeMessege errors = new CodeMessege();
            errors.setError("Not info to this degree");
            errors.setCode("existence");
            return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updatedegree")
    //public ResponseEntity completeTodo(@RequestParam Long id, @RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
    public ResponseEntity completeDegree(@RequestParam(value = "uuid") UUID uuid, @RequestParam(value = "type_degree", required = false) String type_degree, @RequestParam(value = "year_of_graduation", required = false) String year_of_graduation) {
        try {

            Optional<Degree_of_education> g = degreeRepo.findById(uuid);
            Degree_of_education l = degreeRepo.findById(uuid).get();
            if (!type_degree.isEmpty())
            {l.setType_degree(type_degree);}
            if (!year_of_graduation.isEmpty())
            {l.setYear_of_graduation(Integer.parseInt(year_of_graduation));}
            //return Todo.toModel(todoRepo.save(todo));
            degreeRepo.save(l);
            return ResponseEntity.ok(DegreeModel.toModel(l));//todoService.complete(id)
        } catch (Exception e) {
            //return ResponseEntity.badRequest().body("Произошла ошибка");
            CodeMessege errors = new CodeMessege();
            errors.setError("Not info to this degree");
            errors.setCode("existence");
            return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
        }
    }
}
