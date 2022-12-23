package com.example.backendPP.repository;

import com.example.backendPP.entity.teacher;
import com.example.backendPP.entity.type;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TypeRepository extends CrudRepository<type, UUID> {
}
