package com.example.backendPP.repository;

import com.example.backendPP.entity.Degree_of_education;
import com.example.backendPP.entity.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DegreeRepository extends CrudRepository<Degree_of_education, UUID> {
    //Degree_of_education findByDegree_of_education_id(UUID );
    //Degree_of_education findByDegree_of_education_id(UUID degree_of_education_id);
   // Degree_of_education findByDegree_of_education_id(UUID degree_of_education_id);
}
