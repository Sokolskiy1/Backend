package com.example.backendPP.controller;

import com.example.backendPP.entity.*;
import com.example.backendPP.exception.*;
import com.example.backendPP.model.Student;
import com.example.backendPP.model.StudentNecessaryInfa;
import com.example.backendPP.model.StudentWorkModel;
import com.example.backendPP.repository.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;
@ControllerAdvice
@RestController
@RequestMapping("/users")
public class Controller extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<CustomErrorResponse> handleJsonParseException(JsonParseException ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
//                request.getDescription(false));
        //if (ex!=null){
           // String lol ="lol";}
        CustomErrorResponse errors = new CustomErrorResponse();

        errors.setError("капец");
        //LOGGER.warn("Responding with status code {} and exception message {}", status, exception.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        //return new ResponseEntity<>("rtr", HttpStatus.BAD_REQUEST);
    }
    private StudentRepository userRepo;
    private DegreeRepository degreeRepo;

    private DepartmentRepository depRepo;

    private FacultyRepository facRepo;

    private ProductRepository prodRepo;

    private StudentWorkRepository workRepo;

    public Controller(StudentRepository userRepo, FacultyRepository facRepo, DegreeRepository degreeRepo, DepartmentRepository depRepo, ProductRepository prodRepo, StudentWorkRepository workRepo) {
        this.userRepo = userRepo;
        this.facRepo = facRepo;
        this.degreeRepo = degreeRepo;
        this.depRepo = depRepo;
        this.prodRepo=prodRepo;
        this.workRepo=workRepo;
    }



    @PostMapping
    public ResponseEntity registration(@RequestBody studentEntity student, @RequestParam(value = "facultys", required = true) Long facultys,@RequestParam(value = "degree_of_education_id", required = true) UUID degree_of_education_id, @RequestParam(value = "id", required = false) UUID id){
        try {
            //CustomErrorResponse errors = new CustomErrorResponse();


            Optional<studentEntity> posts = userRepo.findById(student.getStudent_card_id());
            if (posts.isPresent())
            {
                //return ResponseEntity.badRequest().body("Такой студенческий номер уже есть");
                CodeMessege errors = new CodeMessege();
                errors.setError("This student number already exist");
                errors.setCode("validation");
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }

            Faculty fac = facRepo.findById(facultys).get();
            student.setFacultys(fac);

            Optional<Degree_of_education> g = degreeRepo.findById(degree_of_education_id);
            student.setDegree_of_education_id(g.get());

            //departament dep = depRepo.findById(id).get();
            if (id!=null){
                Optional<departament> dep = depRepo.findById(id);
                student.setId(dep.get());}



            userRepo.save(student);
            MessegeNewStudentNice nice = new MessegeNewStudentNice();
            nice.setStudent_card_id(student.getStudent_card_id());
            nice.setName(student.getName());
            nice.setPatronymic(student.getPatronymic());
            return new ResponseEntity(nice, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/fullstudent")
    public ResponseEntity getUsers() {
        try {
            //return  ResponseEntity.ok("Сервер работает!");
            Iterable<studentEntity> k = userRepo.findAll();
            List<studentEntity> result = new ArrayList<studentEntity>();
            List<Student> result1 = new ArrayList<Student>();
            k.forEach(result::add);
            //k.forEach(result1::);
             //k.forEach(result1::toModel);
            //Student kr = new Student( k.);
            k.forEach( Student::toModel);
            for (studentEntity i : k) {
                result1.add(Student.toModel(i));
            }
//            Iterable<student_work> l = workRepo.findAll();
//            l.forEach( StudentWorkModel::toModel);
//            for (studentEntity i : k) {
//                result1.add(Student.toModel(i));
//            }

            //Student kr = new Student(userRepo);
            //userRepo.findAll().stream().map(studentEntity::Student.toModel).collect(Collectors.toList());
            //result.stream().map(studentEntity::).collect(Collectors.toList());
            return  ResponseEntity.ok(result1);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/fullstudentmini")
    public ResponseEntity getUsersMini() {
        try {
            //return  ResponseEntity.ok("Сервер работает!");
            Iterable<studentEntity> k = userRepo.findAll();
            List<studentEntity> result = new ArrayList<studentEntity>();
            List<StudentNecessaryInfa> result1 = new ArrayList<StudentNecessaryInfa>();
            k.forEach(result::add);
            k.forEach( StudentNecessaryInfa::toModel);
            for (studentEntity i : k) {
                result1.add(StudentNecessaryInfa.toModel(i));
            }
            return  ResponseEntity.ok(result1);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping("/fullstudentsort")
    public ResponseEntity getUsersMiniSort( @RequestParam(value = "kindofsorting", required = false) Long kindofsorting, @RequestParam(value = "vverh", required = false) Long vverh) {
        try {
            //return  ResponseEntity.ok("Сервер работает!");
            Iterable<studentEntity> k = null;
            if (kindofsorting==1)
                 if (vverh == 1) {
                     k = prodRepo.findAll(Sort.by("Name").ascending());
                 }
                 else k = prodRepo.findAll(Sort.by("Name").descending());//Sort.Direction.ASC,
            if (kindofsorting==2)
                 k = prodRepo.findAll(Sort.by("student_card_id"));
            if (kindofsorting==3)
                k = prodRepo.findAll(Sort.by("Name"));
            List<studentEntity> result = new ArrayList<studentEntity>();
            List<StudentNecessaryInfa> result1 = new ArrayList<StudentNecessaryInfa>();
            k.forEach(result::add);
            k.forEach( StudentNecessaryInfa::toModel);
            for (studentEntity i : k) {
                result1.add(StudentNecessaryInfa.toModel(i));
            }
            return  ResponseEntity.ok(result1);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/getstudent/")
    public ResponseEntity getUser(@RequestParam(value = "id") Long id) {
        try {
            CodeMessege errors = new CodeMessege();
            errors.setError("There is no such student");
            errors.setCode("existence");
            if (!userRepo.findById(id).isEmpty())
                return  ResponseEntity.ok(StudentNecessaryInfa.toModel(userRepo.findById(id).get()));
            return new ResponseEntity(errors, HttpStatus.NOT_FOUND);

        }catch (Exception e){

            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


      @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            //System.out.println();
            Optional<studentEntity> posts = userRepo.findById(id);
            if (!posts.isPresent())
            {
                CodeMessege errors = new CodeMessege();
                errors.setError("There is no such student");
                errors.setCode("existence");
                return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
            }
            studentEntity per = userRepo.findById(id).get();
            userRepo.deleteById(id);
            //return ResponseEntity.ok("Пользователь\nИмя: "+ per.getName() + " " + per.getPatronymic() + " " + per.getSurname() + " " + "удален");
            DeleteMes del = new DeleteMes();
            del.setName(per.getName());
            del.setSurname(per.getSurname());
            del.setPatronymic(per.getPatronymic());
            return ResponseEntity.ok(del);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping("/updatestudent")
    //public ResponseEntity completeTodo(@RequestParam Long id, @RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
    public ResponseEntity completeTodo(@RequestParam(value = "id") Long id, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname,@RequestParam(value = "patronymic", required = false) String patronymic) {
        try {
            Optional<studentEntity> posts = userRepo.findById(id);
            if (!posts.isPresent())
            {
                CodeMessege errors = new CodeMessege();
                errors.setError("There is no such student");
                errors.setCode("existence");
                return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
            }
            studentEntity todo = userRepo.findById(id).get();
            if (name!=null)
            {todo.setName(name);}

            if (surname!=null)
            {todo.setSurname(surname);}

            if (patronymic!=null)
            {todo.setPatronymic(patronymic);}


            userRepo.save(todo);
            //return ResponseEntity.ok("Все хорошо");//todoService.complete(id)
            return new ResponseEntity(StudentNecessaryInfa.toModel(todo), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
//https://stackoverflow.com/questions/63222401/how-to-connect-postgresql-in-gradle-project