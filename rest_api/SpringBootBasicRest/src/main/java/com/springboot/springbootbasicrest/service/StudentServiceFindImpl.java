package com.springboot.springbootbasicrest.service;

import com.springboot.springbootbasicrest.entity.Student;
import com.springboot.springbootbasicrest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceFindImpl implements StudentServiceFind{
    private final StudentRepository studentRepository;
    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
}
