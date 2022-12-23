package com.example.backendPP.repository;

import com.example.backendPP.entity.departament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DepartmentRepository extends CrudRepository<departament, UUID> {
}
