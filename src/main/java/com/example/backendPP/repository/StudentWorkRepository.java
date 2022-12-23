package com.example.backendPP.repository;

import com.example.backendPP.entity.studentEntity;
import com.example.backendPP.entity.student_work;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StudentWorkRepository extends CrudRepository<student_work, UUID> {
}
