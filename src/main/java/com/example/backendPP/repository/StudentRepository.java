package com.example.backendPP.repository;


import com.example.backendPP.entity.studentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<studentEntity, Long> {
    //studentEntity findByUsername(String username);
  // studentEntity findByStudent_card_id(Long student_card_id);
    //studentEntity findByUseronID(Long student_card_id);
    //studentEntity findByUsername(Long student_card_id);
    studentEntity findByName(Long student_card_id);
    //studentEntity deleteById(Long student_card_id);
}