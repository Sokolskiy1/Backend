package com.example.backendPP.repository;

import com.example.backendPP.entity.studentEntity;
import com.example.backendPP.entity.teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TeacherRepository extends CrudRepository<teacher, UUID> {

}
