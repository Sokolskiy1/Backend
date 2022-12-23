package com.example.backendPP.repository;

import com.example.backendPP.entity.Faculty;
import com.example.backendPP.entity.studentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
@Repository
public interface ProductRepository extends PagingAndSortingRepository<studentEntity, Long> {

   // List findAllByPrice(double price, Pageable pageable);
}