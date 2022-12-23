package com.example.backendPP.service;

import com.example.backendPP.entity.studentEntity;
import com.example.backendPP.exception.StudentAlreadyExistException;
import com.example.backendPP.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServise {
    @Autowired
    private StudentRepository studRepo;
/*
    public studentEntity registration(studentEntity user) throws StudentAlreadyExistException {
        if (StudentRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }*/
}